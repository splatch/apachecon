package eu.apachecon.camel.cdi.demo1;

import javax.inject.Inject;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;

import eu.apachecon.camel.cdi.demo1.svc.Service;

@ContextName("first")
public class SimpleRouteBuilder extends RouteBuilder {

    @Inject
    private Service service;

    @Override
    public void configure() throws Exception {
    	from("direct:serviceCall").bean(service);
        from("timer:foo?period=10s").setBody(constant("Mark")).to("direct:serviceCall");
    }

}
