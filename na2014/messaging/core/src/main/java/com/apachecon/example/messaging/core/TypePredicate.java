package com.apachecon.example.messaging.core;

import org.apache.camel.Exchange;
import org.apache.camel.Predicate;

public class TypePredicate implements Predicate
{

    private final Class<?> type;

    public TypePredicate(Class<?> type)
    {
        this.type = type;
    }

    @Override
    public boolean matches(Exchange exchange)
    {
        Object body = exchange.getIn().getBody();
        if (body == null)
        {
            return false;
        }

        return type.isAssignableFrom(body.getClass());
    }

    @Override
    public String toString()
    {
        return type.getSimpleName();
    }
}
