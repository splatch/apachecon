package eu.apachecon.camel.cdi.demo2.ejb;

import javax.ejb.Stateless;

@Stateless
public class ServiceImpl implements Service {

    public String sayHello(String name) {
        return "Hey " + name;
    }

}
