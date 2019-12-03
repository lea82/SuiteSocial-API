package com.advantal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.advantal.model.Messaging;

public interface MessangingRepository extends JpaRepository<Messaging, Integer> {

	@Query(value = "SELECT COUNT (*)  From Messaging  WHERE status=0")
	Long totalUnreadableMessagesCount();

	@Query(value = "SELECT COUNT (*)  From Messaging  WHERE status=1")
	Long totalReadableMessagesCount();

	@Query(value = " SELECT * From messaging_config where message_identifiers = :messageIdentifiers AND sender_type = :senderType", nativeQuery = true)
	List<Messaging> findByMessageIdentifiers(String messageIdentifiers, String senderType);

	@Query(value = " SELECT COUNT(*) From messaging_config where sender_type = :senderType  AND (value_from = :email OR value_to = :email) AND message_identifiers = :messageIdentifiers AND readable_messages = 0", nativeQuery = true)
	long unreadableMessageCount(String email, String senderType, String messageIdentifiers);

	@Query(value = " SELECT *FROM messaging_config WHERE message_identifiers = :messageIdentifier  AND sender_type = :senderType AND (value_from = :email  OR value_to = :email)", nativeQuery = true)
	List<Messaging> showMessageList(String email, String messageIdentifier, String senderType);

	@Query(value = " SELECT COUNT(*) FROM messaging_config WHERE message_identifiers = :messageIdentifier  AND sender_type = :senderType AND (value_from = :email  OR value_to = :email)", nativeQuery = true)
	long numbersOfshowMessageList(String email, String messageIdentifier, String senderType);

	@Query(value = " SELECT * From messaging_config where message_identifiers = :messageIdentifiers", nativeQuery = true)
	List<Messaging> findUserByMessageIdentifiers(String messageIdentifiers);

//	@Query(value = " SELECT COUNT(*) FROM Messaging  WHERE senderType = :senderType AND messageIdentifier = :messageIdentifiers  AND readabaleMessages = :redableMessage ")
	@Query(value = " SELECT COUNT(*) From messaging_config where message_identifiers = :messageIdentifiers AND sender_type = :senderType readable_messages = :redableMessage", nativeQuery = true)
	long unreadableUserMessageCount(String senderType, String messageIdentifiers, int redableMessage);

	@Query(value = " SELECT * From messaging_config where message_identifiers = :messageIdentifiers AND sender_type = :senderType", nativeQuery = true)
	List<Messaging> findUserByMessageIdentifiersAndSenderType(String messageIdentifiers, String senderType);

}
