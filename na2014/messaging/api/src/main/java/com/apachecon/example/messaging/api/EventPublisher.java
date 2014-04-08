package com.apachecon.example.messaging.api;

import java.io.Serializable;

public interface EventPublisher
{

    void publishEvent(Serializable event);

}
