package com.apachecon.example.messaging.core;

/**
 * Configuration property names.
 * 
 * @author dl02
 */
public interface Constants
{

    /**
     * Name of core route.
     */
    String ROUTE_ID = "messaging-route";

    /**
     * Property name which identify "from" part of camel route.
     */
    String FROM = "router.from";

    /**
     * Property name which identify dead letter queue property.
     */
    String DLQ = "router.dlq";

    /**
     * Property name of destination separator.
     */
    String DESTINATION_SEPARATOR = "router.destination.separator";

    /**
     * Default value for destination separator.
     */
    String DEFAULT_DESTINATION_SEPARATOR = ",";

}
