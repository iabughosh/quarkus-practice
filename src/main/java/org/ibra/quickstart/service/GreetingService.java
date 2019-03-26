package org.ibra.quickstart.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {
	
	public String greet(String name) {
		return "Hello ".concat(name);
	}
}
