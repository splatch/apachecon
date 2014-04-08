package com.apachecon.eu2012.camel_cdi;

public class GreeterImpl implements Greeter {

    public String greet(String who) {
        return "Hello " + who;
    }

}
