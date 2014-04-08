package com.apachecon.example.messaging.core;

import static com.apachecon.example.messaging.core.Constants.*;

import org.apache.camel.LoggingLevel;
import org.apache.camel.Predicate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.ChoiceDefinition;
import org.apache.camel.model.MulticastDefinition;
import org.apache.camel.model.RouteDefinition;

public abstract class MessagingRouteBuilder extends RouteBuilder
{

    @Override
    public void configure() throws Exception
    {
        RouteDefinition routeDefinition = from("{{" + FROM + "}}").routeId(ROUTE_ID);
        ChoiceDefinition choice = routeDefinition.choice().id(name("choice"));

        constructChoices(choice);

        choice
            .otherwise().id("otherwise")
                .log(LoggingLevel.WARN, getClass().getName(), "Unable to find destination for message ${in.body}")
                .to("{{"+ DLQ + "}}")
                    .id("send-DLQ");
    }

    protected final void buildWhen(ChoiceDefinition choiceDefinition, Class<?> type, String property) throws Exception
    {
        buildWhen(choiceDefinition, new TypePredicate(type), property);
    }

    protected final void buildWhen(ChoiceDefinition choiceDefinition, Predicate predicate, String property) throws Exception
    {
        String values = getContext().resolvePropertyPlaceholders("{{" + property + "}}");
        String separator = getContext().resolvePropertyPlaceholders("{{" + DESTINATION_SEPARATOR + "}}");

        ChoiceDefinition when = choiceDefinition.when(predicate).id("choice-" + predicate);

        String[] destinations = values.split(separator);
        if (destinations.length == 0)
        {
            when.id(name("send-%s", predicate)).to(destinations[0]);
        }
        else
        {
            MulticastDefinition multicast = when.multicast().id(name("multicast-%s", predicate))
                .parallelProcessing();
            for (String destination : destinations)
            {
                multicast.id(name("multicast-%s-%s", predicate, destination))
                    .to(destination);
            }
        }
    }

    protected abstract void constructChoices(ChoiceDefinition choice) throws Exception;

    protected final static String name(String format, Object ... arguments) {
        return String.format(format, arguments);
    }

}
