package com.joe.springmvc.controller.annotation;

public class SpringManager implements ISpring {
	public String get() {
		System.out.println("------I am springManager----");
		return "I am getMethod";
	}
}
