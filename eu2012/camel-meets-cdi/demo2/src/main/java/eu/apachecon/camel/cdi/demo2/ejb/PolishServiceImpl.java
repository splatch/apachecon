package eu.apachecon.camel.cdi.demo2.ejb;

import eu.apachecon.camel.cdi.demo2.Polish;

@Polish
public class PolishServiceImpl implements Service {

	public String sayHello(String name) {
		return "Witaj " + name;
	}

}
