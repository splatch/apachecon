package com.apachecon.example.messaging.core;

import java.io.Serializable;

import org.apache.camel.ProducerTemplate;

import com.apachecon.example.messaging.api.EventPublisher;

public class CamelEventPublisher implements EventPublisher
{

    private final ProducerTemplate template;

    public CamelEventPublisher(ProducerTemplate template)
    {
        this.template = template;
    }

    @Override
    public void publishEvent(Serializable event)
    {
        template.sendBody(event);
    }

}
