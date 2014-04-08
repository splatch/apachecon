package eu.apachecon.camel.cdi.demo2;

import javax.inject.Inject;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;

import eu.apachecon.camel.cdi.demo2.ejb.Service;

@ContextName("second")
public class SimpleRouteBuilder extends RouteBuilder {

	@Inject
//	@Polish
    private Service service;

	@Override
    public void configure() throws Exception {
        from("servlet:///?matchOnUriPrefix=true&servletName=camel")
    		.setBody(header("who"))
    		.bean(service, "sayHello");
    }

}
