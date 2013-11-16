package com.lohika.rest.controllers;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lohika.rest.domain.Message;
import com.lohika.rest.domain.Status;
import com.lohika.rest.services.MessagesService;
 
/**
 * Controller for restful messages web service.
 * 
 * For more information about WS see:
 * http://localhost:8080/messages 
 * or src/main/webapp/index.html  
 * 
 * @author ashestyuk
 *
 */
@Path("/")
public class MessagesController {
	
	private MessagesService messagesService;
	 
	public MessagesController(MessagesService messagesService) {
		this.messagesService = messagesService;
	}	

	
	/**
	 * Creates the new Message and returns in the response ID of new entry
	 * 
	 * Method processes only POST HTTP requests that were sent on the URLs with pattern:
	 * http://localhost:8080/messages/api/*
	 * 
	 * Method supports JSON and XML format for in/out messages.
	 * Format of request message should be defined in the HTTP header <b>Content-Type</b>. 
	 * Valid content types are:
	 * Content-Type: application/json
	 * Content-Type: application/xml
	 *
	 * Response format depends on the request's HTTP header <b>Accept</b>. 	 
	 * Valid "Accept" headers are:
	 * 
	 * Accept: application/json
	 * Accept: application/xml
	 * 
	 * @param message - domain object for saving
	 * @return status of the operation in the JSON or XML format
	 */
	@POST
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Status createMessage(Message message) {
		return messagesService.createMessage(message);
	} 
	
	/**
	 * Finds the Message object by ID and returns it the response.
	 * 
	 * Method processes only GET HTTP requests that were sent on the URLs with pattern:
	 * http://localhost:8080/messages/api/{message_id}
	 * 
	 * Method supports JSON and XML format for out messages.
	 *
	 * Response format depends on the request's HTTP header <b>Accept</b>. 	 
	 * Valid "Accept" headers are:
	 * 
	 * Accept: application/json
	 * Accept: application/xml
	 * 
	 * @param id of the message to find
	 * @return status of the operation in the JSON or XML format
	 */
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Status getMessageById(@PathParam("id") int id) {
		return messagesService.getMessageById(id);
	}
	
	/**
	 * Updates the Message object by ID and returns in the response amount of processed entries (0 or 1 by design).
	 * 
	 * Method processes only PUT HTTP requests that were sent on the URLs with pattern:
	 * http://localhost:8080/messages/api/{message_id}
	 * 
	 * Method supports JSON and XML format for in/out messages.
	 * Format of request message should be defined in the HTTP header <b>Content-Type</b>. 
	 * Valid content types are:
	 * Content-Type: application/json
	 * Content-Type: application/xml
	 *
	 * Response format depends on the request's HTTP header <b>Accept</b>. 	 
	 * Valid "Accept" headers are:
	 * 
	 * Accept: application/json
	 * Accept: application/xml
	 * 
	 * @param id of the message to find
	 * @param message - domain object for saving
	 * @return status of the operation in the JSON or XML format
	 */
	@PUT
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Status updateMessageById(@PathParam("id") int id, Message message) {
		return messagesService.updateMessage(id, message);
	} 
	
	/**
	 * Deletes the Message object by ID and returns in the response amount of processed entries (0 or 1 by design).
	 * 
	 * Method processes only DELETE HTTP requests that were sent on the URLs with pattern:
	 * http://localhost:8080/messages/api/{message_id}
	 * 
	 * Method supports JSON and XML format for out messages.
	 *
	 * Response format depends on the request's HTTP header <b>Accept</b>. 	 
	 * Valid "Accept" headers are:
	 * 
	 * Accept: application/json
	 * Accept: application/xml
	 * 
	 * @param id of the message to delete
	 * @return status of the operation in the JSON or XML format
	 */
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Status deleteMessageById(@PathParam("id") int id) {
		return messagesService.deleteMessageById(id);
	} 
}