package com.lgcns.test;

public abstract class State {

	private String name;
	private String next;

	public State(String name, String next) {
		super();
		this.name = name;
		this.next = next;
	}

	public String getName() {
		return name;
	}

	public String getNext() {
		return next;
	}

	public abstract String run() throws Exception;
	
}
