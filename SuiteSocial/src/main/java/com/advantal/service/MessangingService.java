package com.advantal.service;

import java.util.Map;

import org.springframework.data.jpa.repository.Query;

import com.adantal.vo.MessagingResponseVo;
import com.advantal.model.Messaging;

public interface MessangingService {

	@Query(value = "SELECT COUNT(*) FROM MESSANGING ")
	Map<Object, Object> sendingMessage(Messaging messanging);

	Map<Object, Object> getRecentMessages(String messageIdentifiers, String senderType);

	Map<Object, Object> showMessageList(MessagingResponseVo messagingResponseVo);

	Map<Object, Object> showSingleMessage(MessagingResponseVo messagingResponseVo);

	Map<Object, Object> deleteMessage(MessagingResponseVo messagingResponseVo);

}
