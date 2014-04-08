package eu.apachecon.camel.cdi.demo2.ejb;

import javax.ejb.Local;

@Local
public interface Service {

    String sayHello(String name);

}
