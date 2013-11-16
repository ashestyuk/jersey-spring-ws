package com.lohika.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.lohika.rest.domain.Message;

/**
 * JDBC implementation of Messages DAO
 * 
 * @author ashestyuk
 *
 */
public class JdbcMessagesDao extends JdbcDaoSupport implements MessagesDao {

	private static final String SQL_INSERT_MESSAGE = 
			"INSERT INTO Messages(title, body, timestamp) VALUES (?, ?, ?)";
	private static final String SQL_SELECT_MESSAGE_BY_ID = 
			"SELECT id, title, body, timestamp FROM messages WHERE id = ?";
	private static final String SQL_UPDATE_MESSAGE_BY_ID = 
			"UPDATE Messages SET title=?, body=?, timestamp=? WHERE id=?";	
	private static final String SQL_DELETE_MESSAGE_BY_ID = 
			"DELETE FROM messages WHERE id = ?";
	
	
	/* (non-Javadoc)
	 * @see com.lohika.db.dao.MessagesDao#getMessageById(int)
	 */
	@Override
	public Message getMessageById(int id) {
		return getJdbcTemplate().queryForObject(SQL_SELECT_MESSAGE_BY_ID,
				new ParameterizedRowMapper<Message>() {
					public Message mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Message message = new Message();
						message.setId(rs.getInt(1));
						message.setTitle(rs.getString(2));
						message.setBody(rs.getString(3));
						message.setTimestamp(rs.getLong(4));
						return message;
					}
				}, id);
	}


	/* (non-Javadoc)
	 * @see com.lohika.db.dao.MessagesDao#deleteMessageById(int)
	 */
	@Override
	public int deleteMessageById(int id) {
		return getJdbcTemplate().update(SQL_DELETE_MESSAGE_BY_ID, id);
	}


	/* (non-Javadoc)
	 * @see com.lohika.db.dao.MessagesDao#createMessage(com.lohika.rest.domain.Message)
	 */
	@Override
	public int createMessage(final Message mes) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(
		    new PreparedStatementCreator() {
		        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
		            PreparedStatement ps =
		                connection.prepareStatement(SQL_INSERT_MESSAGE, new String[] {"id"});
		            ps.setString(1, mes.getTitle());
		            ps.setString(2, mes.getBody());
		            ps.setLong(3, mes.getTimestamp());
		            return ps;
		        }
		    },
		    keyHolder);
		return keyHolder.getKey().intValue(); // new message's ID
	}


	/* (non-Javadoc)
	 * @see com.lohika.db.dao.MessagesDao#updateMessage(int, com.lohika.rest.domain.Message)
	 */
	@Override
	public int updateMessage(int id, Message mes) {
		return getJdbcTemplate()
			.update(SQL_UPDATE_MESSAGE_BY_ID, mes.getTitle(), mes.getBody(), mes.getTimestamp(), id);
	}
}
