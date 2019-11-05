package com.advantal.model;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "messaging_config")
public class Messaging {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "value_from")
	private String from;

	@Column(name = "value_to")
	private String to;

	@Column(name = "sender_type")
	private String senderType;

	@Column(name = "message_outBounds")
	private Integer messageOutBounds;

	@Column(name = "message_title")
	private String messageTitle;

	@Column(name = "message_body")
	private String messageBody;

	@Column(name = "date")
	private Date date;

	@Column(name = "time")
	private LocalTime time;

	@Column(name = "timeStamp")
	private Long timeStamp;

	@Column(name = "readable_messages")
	private Integer readabaleMessages;

	@Column(name = "message_identifiers")
	private String messageIdentifier;

	@Column(name = "unreadableMessageCount")
	private Integer unreadableMessageCount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSenderType() {
		return senderType;
	}

	public void setSenderType(String senderType) {
		this.senderType = senderType;
	}

	public Integer getMessageOutBounds() {
		return messageOutBounds;
	}

	public void setMessageOutBounds(Integer messageOutBounds) {
		this.messageOutBounds = messageOutBounds;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getReadabaleMessages() {
		return readabaleMessages;
	}

	public void setReadabaleMessages(Integer readabaleMessages) {
		this.readabaleMessages = readabaleMessages;
	}

	public String getMessageIdentifier() {
		return messageIdentifier;
	}

	public void setMessageIdentifier(String messageIdentifier) {
		this.messageIdentifier = messageIdentifier;
	}

	public Integer getUnreadableMessageCount() {
		return unreadableMessageCount;
	}

	public void setUnreadableMessageCount(Integer unreadableMessageCount) {
		this.unreadableMessageCount = unreadableMessageCount;
	}

	@Override
	public String toString() {
		return "Messaging [id=" + id + ", from=" + from + ", to=" + to + ", senderType=" + senderType
				+ ", messageOutBounds=" + messageOutBounds + ", messageTitle=" + messageTitle + ", messageBody="
				+ messageBody + ", date=" + date + ", time=" + time + ", timeStamp=" + timeStamp
				+ ", readabaleMessages=" + readabaleMessages + ", messageIdentifier=" + messageIdentifier
				+ ", unreadableMessageCount=" + unreadableMessageCount + "]";
	}

	

	
}
