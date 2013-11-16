package com.lohika.rest.services;

import com.lohika.rest.domain.Message;
import com.lohika.rest.domain.Status;

/**
 * Messages' service interface
 * 
 * @author ashestyuk
 */
public interface MessagesService {	
	/**
	 * Finds message by ID
	 * 
	 * @param id of the message
	 * @return status domain object
	 */
	Status getMessageById(int id);
	
	/**
	 * Deletes message by ID
	 * 
	 * @param id of the message
	 * @return status domain object
	 */
	Status deleteMessageById(int id);
	
	/**
	 * Creates new message
	 * 
	 * @param message - new message object
	 * @return status domain object
	 */
	Status createMessage(Message message);
	
	/**
	 * Updates message
	 * 
	 * @param id of the message
	 * @param message - updated message object
	 * @return status domain object
	 */
	Status updateMessage(int id, Message message);
	
}