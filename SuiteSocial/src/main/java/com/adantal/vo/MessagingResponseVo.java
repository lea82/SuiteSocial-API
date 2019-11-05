package com.adantal.vo;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlElement;

public class MessagingResponseVo {

	@XmlElement(name = "message_id")
	private Integer id;
	@XmlElement(name = "message_email")
	private String email;
	@XmlElement(name = "message_latestMessage")
	private String latestMessage;

	@Column(name = "timeStamp")
	private Long timeStamp;

	@XmlElement(name = "unread_message_count")
	private Long unreadMessagesCount;

	@Column(name = "message_identifiers")
	private String messageIdentifier;

	@Column(name = "sender_type")
	private String senderType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLatestMessage() {
		return latestMessage;
	}

	public void setLatestMessage(String latestMessage) {
		this.latestMessage = latestMessage;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public String getSenderType() {
		return senderType;
	}

	public void setSenderType(String senderType) {
		this.senderType = senderType;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Long getUnreadMessagesCount() {
		return unreadMessagesCount;
	}

	public void setUnreadMessagesCount(Long unreadMessagesCount) {
		this.unreadMessagesCount = unreadMessagesCount;
	}

	public String getMessageIdentifier() {
		return messageIdentifier;
	}

	public void setMessageIdentifier(String messageIdentifier) {
		this.messageIdentifier = messageIdentifier;
	}

	@Override
	public String toString() {
		return "MessagingResponseVo [id=" + id + ", email=" + email + ", latestMessage=" + latestMessage
				+ ", timeStamp=" + timeStamp + ", unreadMessagesCount=" + unreadMessagesCount + ", messageIdentifier="
				+ messageIdentifier + ", senderType=" + senderType + "]";
	}

}
