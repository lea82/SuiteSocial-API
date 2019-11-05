package com.advantal.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adantal.vo.MessagingResponseVo;
import com.advantal.model.Messaging;
import com.advantal.service.MessangingService;

@RestController
@RequestMapping("/messanging")
public class MessangingController {

	@Autowired
	MessangingService messangingService;

	@PostMapping("/sendingMessage")
	public Map<Object, Object> sendingMessage(@RequestBody Messaging messanging) {

		return messangingService.sendingMessage(messanging);

	}

	@PostMapping("/recentMessage")
	public Map<Object, Object> getMessageByID(@RequestBody Map<String, String> reqParams) {
		String messageIdentifiers = reqParams.get("messageIdentifiers");
		String senderType = reqParams.get("senderType");

		return messangingService.getRecentMessages(messageIdentifiers, senderType);

	}

	@PostMapping("/showmessageList")
	public Map<Object, Object> showMessageList(@RequestBody MessagingResponseVo messagingResponseVo) {
		return messangingService.showMessageList(messagingResponseVo);
	}

	@PostMapping("/updateRedabelMesage")
	public Map<Object, Object> showSingleMessage(@RequestBody MessagingResponseVo messagingResponseVo) {
		return messangingService.showSingleMessage(messagingResponseVo);
	}

	@PostMapping("/deleteMessage")
	public Map<Object, Object> deleteMessage(@RequestBody MessagingResponseVo messagingResponseVo) {
		return messangingService.deleteMessage(messagingResponseVo);
	}

}
