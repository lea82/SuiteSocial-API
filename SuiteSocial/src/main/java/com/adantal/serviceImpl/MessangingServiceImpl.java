package com.adantal.serviceImpl;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adantal.vo.MessagingResponseVo;
import com.advantal.model.Messaging;
import com.advantal.repository.MessangingRepository;
import com.advantal.service.MessangingService;
import com.advantal.util.ConstantAction;
import com.advantal.util.IConstant;
import com.advantal.util.SendMailProperty;

@Service
public class MessangingServiceImpl implements MessangingService {

	@Autowired
	private MessangingRepository messangingRepository;

	public String msg;

	@Override
	public Map<Object, Object> sendingMessage(Messaging messanging) {
		Map<Object, Object> map = new HashMap<Object, Object>();

		String senderType = null;
		String receiverType = null;

		Date date = new Date();
		LocalTime time = LocalTime.now();

		try {

			long currenttimeInStamp = Calendar.getInstance().getTimeInMillis();

			if (messanging.getSenderType().equals("1")) // 1 cmny , 2 influencer
			{

				senderType = IConstant.cmpany_Survey;
				receiverType = IConstant.influencer_survey;
			} else {

				senderType = IConstant.influencer_survey;
				receiverType = IConstant.cmpany_Survey;
			}

			Messaging messagingForSender = new Messaging();

			Messaging messagingForReceiver = new Messaging();

			messagingForSender.setFrom(messanging.getFrom());
			messagingForSender.setTo(messanging.getTo());
			messagingForSender.setMessageOutBounds(1);
			messagingForSender.setMessageTitle(messanging.getMessageTitle());
			messagingForSender.setMessageBody(messanging.getMessageBody());
			messagingForSender.setSenderType(senderType);
			messagingForSender.setDate(date);
			messagingForSender.setTime(time);
			messagingForSender.setTimeStamp(currenttimeInStamp);
			messagingForSender.setReadabaleMessages(1);
			messagingForSender.setMessageIdentifier(messanging.getFrom());

			messagingForReceiver.setFrom(messanging.getFrom());
			messagingForReceiver.setTo(messanging.getTo());
			messagingForReceiver.setMessageOutBounds(0);
			messagingForReceiver.setMessageTitle(messanging.getMessageTitle());
			messagingForReceiver.setMessageBody(messanging.getMessageBody());
			messagingForReceiver.setSenderType(receiverType);
			messagingForReceiver.setDate(date);
			messagingForReceiver.setTime(time);
			messagingForReceiver.setTimeStamp(currenttimeInStamp);
			messagingForReceiver.setReadabaleMessages(0);
			messagingForReceiver.setMessageIdentifier(messanging.getTo());

			Session session = SendMailProperty.mailProperty();

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(ConstantAction.FROM_EMAIL_ID));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(messanging.getTo()));
			message.setSubject(messanging.getMessageTitle());
			message.setText(
					"You have a new message from " + messanging.getFrom() + '\n' + '\n' + messanging.getMessageBody());

			/** send the message by using mail api **/
			Transport.send(message);

			System.out.println("mail send successfully...");
			Messaging messangingObj = messangingRepository.save(messagingForSender);
			Messaging messangingObj1 = messangingRepository.save(messagingForReceiver);

			System.out.println("messangingObj=" + messangingObj);
			System.out.println("messangingObj1=" + messangingObj1);

			map.put(IConstant.RESPONSE, IConstant.SUCCESS);
			map.put(IConstant.MESSAGE, "Mail sent successfully...");
			// map.put(IConstant.OBJECT, messangingObj);

		} catch (Exception e) {
			System.out.println("Message not send. ");
			map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
			map.put(IConstant.MESSAGE, "Mail not sent");
			e.printStackTrace();
		}

		return map;
	}

	@Override
	public Map<Object, Object> getRecentMessages(String messageIdentifiers, String senderType) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<MessagingResponseVo> responseMessagingList = new ArrayList<MessagingResponseVo>();

		try {

			if (senderType.equals("1"))
				senderType = IConstant.cmpany_Survey;

			else
				senderType = IConstant.influencer_survey;

			List<Messaging> messangingListForMessageIdentifiers = new ArrayList<Messaging>();

			messangingListForMessageIdentifiers = messangingRepository
					.findUserByMessageIdentifiersAndSenderType(messageIdentifiers, senderType);

			System.out.println("1 messangingListForMessageIdentifiers =" + messangingListForMessageIdentifiers);

			Map<String, Integer> emailForSender = new HashMap<String, Integer>();
			Map<String, Integer> emailForRecever = new HashMap<String, Integer>();

			for (Messaging messaging : messangingListForMessageIdentifiers) {

				if (!(messaging.getFrom().equals(messageIdentifiers) && messaging.getSenderType().equals(senderType)))
					emailForSender.put(messaging.getFrom(), messaging.getId());

				if (!(messaging.getTo().equals(messageIdentifiers) && messaging.getSenderType().equals(senderType)))
					emailForRecever.put(messaging.getTo(), messaging.getId());

				if (messaging.getFrom().equals(messaging.getTo()) && messaging.getSenderType().equals(senderType)) {
					emailForRecever.put(messaging.getTo(), messaging.getId());

					System.out.println("  same data =");

				}
			}
			System.out.println("2 emailForSender =" + emailForSender);
			System.out.println("3 emailForRecever =" + emailForRecever);

			if (!emailForSender.isEmpty() && emailForRecever.isEmpty()) {
				for (Map.Entry<String, Integer> senderEntry : emailForSender.entrySet()) {

					if (emailForRecever.containsKey(senderEntry.getKey())) {
						if (senderEntry.getValue() == emailForRecever.get(senderEntry.getKey())) {

							emailForRecever.remove(senderEntry.getKey());
						}
					}
				}
			}

			System.out.println("3 emailForSender =" + emailForSender);
			System.out.println("4 emailForRecever =" + emailForRecever);

			Map<String, Integer> OverallRecentRecords = new HashMap<String, Integer>();
			List<String> emailForReceverKeys = new ArrayList<String>();

			if (emailForSender.isEmpty() && !emailForRecever.isEmpty())
				OverallRecentRecords = emailForRecever;

			if (!emailForSender.isEmpty() && emailForRecever.isEmpty())
				OverallRecentRecords = emailForSender;

			if (!emailForSender.isEmpty() && !emailForRecever.isEmpty()) {

				for (Map.Entry<String, Integer> senderEntry : emailForSender.entrySet()) {

					if (emailForRecever.containsKey(senderEntry.getKey())) {

						emailForReceverKeys.add(senderEntry.getKey());

						if (senderEntry.getValue() > emailForRecever.get(senderEntry.getKey())) {
							OverallRecentRecords.put(senderEntry.getKey(), senderEntry.getValue());

						}

						if (senderEntry.getValue() < emailForRecever.get(senderEntry.getKey())) {
							OverallRecentRecords.put(senderEntry.getKey(), emailForRecever.get(senderEntry.getKey()));

						}

					}
					
				}
			}

			/**
			 * Removing all entry base on email from sender And Recever because of we
			 * already add into OverallRecentRecords after compaire.
			 **/
			for (String removedMapEntry : emailForReceverKeys) {

				emailForSender.remove(removedMapEntry);
				emailForRecever.remove(removedMapEntry);

			}

			/** Remaining Entries add into OverallRecentRecords. **/

			if (!emailForRecever.isEmpty()) {

				for (Map.Entry<String, Integer> receverEntry : emailForSender.entrySet()) {
					OverallRecentRecords.put(receverEntry.getKey(), receverEntry.getValue());

				}
			}

			/** Remaining Entries add into OverallRecentRecords. **/
			if (!emailForSender.isEmpty()) {

				for (Map.Entry<String, Integer> senderEntry : emailForSender.entrySet()) {
					OverallRecentRecords.put(senderEntry.getKey(), senderEntry.getValue());

				}
			}

			for (Map.Entry<String, Integer> OverallRecentRecordsEntry : OverallRecentRecords.entrySet()) {

				MessagingResponseVo repsonseMessage = new MessagingResponseVo();

				repsonseMessage.setId(OverallRecentRecordsEntry.getValue());
				repsonseMessage.setEmail(OverallRecentRecordsEntry.getKey());

				Optional<Messaging> getMessageById = messangingRepository
						.findById(OverallRecentRecordsEntry.getValue());

				/*
				 * long unreadableMessageCount = messangingRepository
				 * .unreadableMessageCount(OverallRecentRecordsEntry.getKey(), senderType,
				 * messageIdentifiers);
				 */
				long unreadableMessageCount = 0;
				/*
				 * long unreadableMessageCount =
				 * messangingRepository.unreadableUserMessageCount(senderType,
				 * messageIdentifiers, 0);
				 */
				System.out.println("unreadableMessageCount=" + unreadableMessageCount);
				if (unreadableMessageCount > 0)
					repsonseMessage.setUnreadMessagesCount(unreadableMessageCount);
				else
					repsonseMessage.setUnreadMessagesCount(unreadableMessageCount);

				repsonseMessage.setLatestMessage(getMessageById.get().getMessageBody());
				repsonseMessage.setTimeStamp(getMessageById.get().getTimeStamp());
				repsonseMessage.setMessageIdentifier(messageIdentifiers);

				if (senderType.equals(IConstant.cmpany_Survey))
					repsonseMessage.setSenderType("1");
				else
					repsonseMessage.setSenderType("2");

				responseMessagingList.add(repsonseMessage);

			}

			System.out.println("responseMessagingList=" + responseMessagingList);

			if (!responseMessagingList.isEmpty()) {
				map.put(IConstant.RESPONSE, IConstant.SUCCESS);
				map.put(IConstant.MESSAGE, "Recent Messages Identifier for " + messageIdentifiers);
			} else {
				map.put(IConstant.MESSAGE, "No any Message exist for particular " + messageIdentifiers);
				map.put("Total Numbers of Records Founds ", 0);
			}

			map.put(IConstant.OBJECT, responseMessagingList);

		} catch (Exception e) {
			
			map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
			map.put(IConstant.MESSAGE, "No any Message exist for particular " + messageIdentifiers);
			map.put("Total Numbers of Records Founds ", 0);
			map.put(IConstant.OBJECT, responseMessagingList);
		}
		return map;
	}

	@Override
	public Map<Object, Object> showMessageList(MessagingResponseVo messagingResponseVo) {
		Map<Object, Object> map = new HashMap<Object, Object>();

		List<Messaging> listOfMessages = new ArrayList<Messaging>();
		String senderType = null;

		try {
			if (messagingResponseVo.getSenderType().equals("1")) // 1 cmny , 2 influencer

				senderType = IConstant.cmpany_Survey;

			else

				senderType = IConstant.influencer_survey;

			listOfMessages = messangingRepository.showMessageList(messagingResponseVo.getEmail(),
					messagingResponseVo.getMessageIdentifier(), senderType);

			System.out.println("listOfMessages=" + listOfMessages);

			long noOfRecords = messangingRepository.numbersOfshowMessageList(messagingResponseVo.getEmail(),
					messagingResponseVo.getMessageIdentifier(), senderType);

			if (!listOfMessages.isEmpty()) {
				map.put(IConstant.RESPONSE, IConstant.SUCCESS);
				map.put(IConstant.MESSAGE,
						"Recent Messages Identifier for " + messagingResponseVo.getMessageIdentifier());
				map.put("Total Numbers of Records Founds ", noOfRecords);
				map.put(IConstant.OBJECT, listOfMessages);

			} else {
				map.put(IConstant.MESSAGE,
						"No any Message exist for particular " + messagingResponseVo.getMessageIdentifier());
				map.put("Total Numbers of Records Founds ", 0);
			}

		} catch (Exception e) {
			map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
			map.put(IConstant.MESSAGE,
					"No any Message exist for particular " + messagingResponseVo.getMessageIdentifier());
			map.put("Total Numbers of Records Founds ", 0);
			map.put(IConstant.OBJECT, listOfMessages);
		}

		return map;
	}

	@Override
	public Map<Object, Object> showSingleMessage(MessagingResponseVo messagingResponseVo) {

		Map<Object, Object> map = new HashMap<Object, Object>();
		Optional<Messaging> messagingRecord = null;
		Messaging messaging = new Messaging();

		System.out.println("messagingResponseVo=" + messagingResponseVo);

		try {
			messagingRecord = messangingRepository.findById(messagingResponseVo.getId());

			/** Update unreadableMessage with 1 if message Read. **/
			messaging.setId(messagingRecord.get().getId());
			messaging.setFrom(messagingRecord.get().getFrom());
			messaging.setTo(messagingRecord.get().getTo());
			messaging.setSenderType(messagingRecord.get().getSenderType());
			messaging.setMessageOutBounds(messagingRecord.get().getMessageOutBounds());
			messaging.setMessageTitle(messagingRecord.get().getMessageTitle());
			messaging.setMessageBody(messagingRecord.get().getMessageBody());
			messaging.setDate(messagingRecord.get().getDate());
			messaging.setTime(messagingRecord.get().getTime());
			messaging.setTimeStamp(messagingRecord.get().getTimeStamp());
			messaging.setReadabaleMessages(1);
			messaging.setMessageIdentifier(messagingRecord.get().getMessageIdentifier());
			messaging.setUnreadableMessageCount(messagingRecord.get().getUnreadableMessageCount());

			messaging = messangingRepository.save(messaging);

			System.out.println("messaging =" + messaging);

			map.put(IConstant.RESPONSE, IConstant.SUCCESS);
			map.put(IConstant.MESSAGE, "Please check Messages  ");
			map.put(IConstant.OBJECT, messaging);

		} catch (Exception e) {

			map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
			map.put(IConstant.MESSAGE, "No any Message exist ");

		}

		return map;
	}

	/** Delete message **/
	@Override
	public Map<Object, Object> deleteMessage(MessagingResponseVo messagingResponseVo) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		try {

			messangingRepository.deleteById(messagingResponseVo.getId());
			map.put(IConstant.RESPONSE, IConstant.SUCCESS);
			map.put(IConstant.MESSAGE, "Deleted Record Successfully...  ");

		} catch (Exception e) {
			map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
			map.put(IConstant.MESSAGE, "Message not deleted.. ");

		}
		return map;
	}

}
