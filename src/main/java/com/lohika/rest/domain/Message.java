package com.lohika.rest.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Message domain object. 
 * It used for both the request and the response.
 * 
 * @author ashestyuk
 *
 */
@XmlRootElement
public class Message {
	
	private int id;	
	private String title;
	private String body;
	private long timestamp;	
	
	public Message() {}
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", title=" + title + ", body=" + body
				+ ", timestamp=" + timestamp + "]";
	}
}