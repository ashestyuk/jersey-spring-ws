package com.lohika.db.dao;

import com.lohika.rest.domain.Message;

/**
 * Messages DAO interface 
 * 
 * @author ashestyuk
 *
 */
public interface MessagesDao { 
	
	/**
	 * Finds message by ID
	 * 
	 * @param id of the message in the DB
	 * @return message domain object
	 */
	Message getMessageById(int id);
	
	/**
	 * Deletes message by ID
	 * 
	 * @param id of the message in the DB
	 * @return amount of deleted entries (by design 1 or 0 if wrong id was used)
	 */
	int deleteMessageById(int id);
	
	/**
	 * Creates new message
	 * 
	 * @param message - new message object
	 * @return ID in the DB for new message
	 */
	
	int createMessage(Message message);
	
	/**
	 * Updates message
	 * 
	 * @param id of the message
	 * @param message - updated message object
	 * @return amount of updated entries (by design 1 or 0 if wrong id was used)
	 */
	int updateMessage(int id, Message message);
}