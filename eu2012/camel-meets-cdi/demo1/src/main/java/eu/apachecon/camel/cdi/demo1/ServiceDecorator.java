package eu.apachecon.camel.cdi.demo1;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

import eu.apachecon.camel.cdi.demo1.svc.Service;

@Decorator
public class ServiceDecorator implements Service {

    @Inject @Delegate
    private Service service;

    public String sayHello(String name) {
        System.out.println("Before calling " + service);
        return service.sayHello(name);
    }

}
