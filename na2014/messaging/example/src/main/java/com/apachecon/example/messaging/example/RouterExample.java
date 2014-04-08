package com.apachecon.example.messaging.example;

import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.apache.camel.model.ChoiceDefinition;

import com.apachecon.example.messaging.core.MessagingRouteBuilder;

public class RouterExample extends MessagingRouteBuilder {

    @Override
    protected void constructChoices(ChoiceDefinition choice) throws Exception {
        buildWhen(choice, Date.class, "endpoint-property-name");
        buildWhen(choice, Long.class, "another-property-name");

        buildWhen(choice, new Predicate() {
            @Override
            public boolean matches(Exchange exchange) {
                return exchange.getIn().getHeader("some-flag", String.class) != null;
            }
        }, "yet-another-property");
    }

}
