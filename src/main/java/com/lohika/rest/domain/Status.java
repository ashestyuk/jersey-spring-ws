package com.lohika.rest.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Status domain object. 
 * It used for the response.
 * 
 * @author ashestyuk
 *
 */
@XmlRootElement
public class Status {
	
	private String operation; 
	private int records = -1; 
	private int id = -1; 
	private String error = ""; 
	private Message message;
	
	public Status() {}
	
	public Status(int id, String operation) {
		this.id = id;
		this.operation = operation;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "Status [operation=" + operation + ", records=" + records
				+ ", id=" + id + ", error=" + error + ", message=" + message
				+ "]";
	}
}