package eu.apachecon.camel.cdi.demo1.svc;


public class ServiceImpl implements Service {

    public String sayHello(String name) {
        System.out.println("Saying hello to " + name);
        return "Hey " + name;
    }

}
