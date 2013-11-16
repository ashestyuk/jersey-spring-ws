package com.lohika.rest.services;

import com.lohika.db.dao.MessagesDao;
import com.lohika.rest.domain.Message;
import com.lohika.rest.domain.Status;


/**
 * Implementation of messages' service interface
 * 
 * @author ashestyuk *
 */
public class MessagesServiceImpl implements MessagesService{
	
	private MessagesDao messagesDao;	

	public MessagesServiceImpl(MessagesDao messagesDao) {
		this.messagesDao = messagesDao;
	}

	/* (non-Javadoc)
	 * @see com.lohika.rest.services.MessagesService#getMessageById(int)
	 */
	@Override
	public Status getMessageById(int id) {
		Status result = new Status(id, "GET");	
		try {
			result.setMessage(messagesDao.getMessageById(id));
			result.setRecords(1);
		} catch (Exception e) {
			result.setError(String.valueOf(e));
			result.setRecords(0);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.lohika.rest.services.MessagesService#deleteMessageById(int)
	 */
	@Override
	public Status deleteMessageById(int id) {
		Status result = new Status(id, "DELETE");	
		try {
			result.setRecords(messagesDao.deleteMessageById(id));
		} catch (Exception e) {
			result.setError(String.valueOf(e));
			result.setRecords(0);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.lohika.rest.services.MessagesService#createMessage(com.lohika.rest.domain.Message)
	 */
	@Override
	public Status createMessage(Message message) {
		Status result = new Status();	
		result.setOperation("POST");
		try {
			result.setId(messagesDao.createMessage(message));			
			result.setRecords(1);
		} catch (Exception e) {
			result.setMessage(message);
			result.setError(String.valueOf(e));
			result.setRecords(0);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.lohika.rest.services.MessagesService#updateMessage(int, com.lohika.rest.domain.Message)
	 */
	@Override
	public Status updateMessage(int id, Message message) {
		Status result = new Status(id, "PUT");	
		try {
			result.setRecords(messagesDao.updateMessage(id, message));
		} catch (Exception e) {
			result.setMessage(message);
			result.setError(String.valueOf(e));
			result.setRecords(0);
		}
		return result;
	}
}