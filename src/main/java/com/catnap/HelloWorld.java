package com.catnap;

import javax.jdo.annotations.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HelloWorld {
	
	@Id
	int messageId;
	
	@Column
	String helloMessage;

	public HelloWorld(int messageId, String helloMessage) {
		super();
		this.messageId = messageId;
		this.helloMessage = helloMessage;
	}
	

	public HelloWorld() {}
	
	public String getHelloMessage() {
		return helloMessage;
	}

	public void setHelloMessage(String helloMessage) {
		this.helloMessage = helloMessage;
	}

	@Override
	public String toString() {
		return "HelloWorld [messageId=" + messageId + ", helloMessage=" + helloMessage + "]";
	}
}
