package services

import data.ChatData
import data.MessageData
import data.UserData
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ChatServiceTest {

    @BeforeEach
    fun clearBeforeTest() {
        ChatService.clear()
    }

    @Test
    fun getChats() {
        val message1 = MessageData(
            "Hello",
            2024,
            user = UserData("Sergey", 0),
            chatId = 0,
            0,
            isDeleted = false,
            isChecked = false
        )
        ChatService.createMessage(1, message1)
        val expectedAnswer = ChatData(id = 1, user = UserData("Sergey", 0))
        assertEquals(expectedAnswer, ChatService.getChats().first())
    }

    @Test
    fun getUnreadChatsCount() {
        val message1 = MessageData(
            "Hello",
            2024,
            user = UserData("Sergey", 0),
            chatId = 0,
            0,
            isDeleted = false,
            isChecked = false
        )
        ChatService.createMessage(1, message1)
        val returnUnreaded = ChatService.getUnreadChatsCount()
        assertEquals(mapOf(1 to 1), returnUnreaded)
    }

    @Test
    fun getUserMessagesInChat() {
        val message1 = MessageData(
            "Hello",
            2024,
            user = UserData("Sergey", 0),
            chatId = 0,
            0,
            false,
            isChecked = false
        )
        ChatService.createMessage(1, message1)
        val messageForCheck = message1.copy(chatId = 1, id = 1, isChecked = false)
        val checkMessage = ChatService.getUserMessagesInChat(0, 3, 1)
        assertEquals(messageForCheck, checkMessage.first())
    }

    @Test
    fun deleteChat() {
        val message1 = MessageData(
            "Hello",
            2024,
            user = UserData("Sergey", 0),
            chatId = 0,
            0,
            false,
            isChecked = false
        )
        ChatService.createMessage(1, message1)
        val deletedChat = ChatService.deleteChat(1, ChatData())
        assertEquals(true, deletedChat)
    }

    @Test
    fun createMessage() {
        val message1 = MessageData(
            "Hello",
            2024,
            user = UserData("Sergey", 0),
            chatId = 0,
            0,
            false,
            isChecked = false
        )
        ChatService.createMessage(1, message1)
        val newCreatedMessage = message1.copy(chatId = 1, id = 1)
        val checkMessage = ChatService.getUserMessagesInChat(0, 3, 1)
        assertEquals(checkMessage.first(), newCreatedMessage)
    }

    @Test
    fun updateMessage() {
        val message1 = MessageData(
            "Hello",
            2024,
            user = UserData("Sergey", 0),
            chatId = 0,
            0,
            isDeleted = false,
            isChecked = false
        )
        ChatService.createMessage(1, message1)
        val updateMessage = MessageData(
            "Im updated Message",
            2024,
            user = UserData("Sergey", 0),
            chatId = 0,
            0,
            false,
            isChecked = false
        )
        val update = ChatService.updateMessage(1, updateMessage)
        assertEquals(true, update)
    }

    @Test
    fun deleteMessage() {
        val message1 = MessageData(
            "Hello",
            2024,
            user = UserData("Sergey", 0),
            chatId = 0,
            0,
            false,
            isChecked = false
        )
        ChatService.createMessage(1, message1)
        val deleteMessage = ChatService.deleteMessage(1, MessageData())
        assertEquals(true, deleteMessage)
    }

    @Test
    fun getLastMessagesOfAllChats() {
        val message1 = MessageData(
            "Hello",
            2024,
            user = UserData("Sergey", 0),
            chatId = 0,
            0,
            false,
            isChecked = false
        )
        ChatService.createMessage(1, message1)
        val message2 = MessageData(
            "Hi",
            2024,
            user = UserData("Sergey", 0),
            chatId = 0,
            0,
            false,
            isChecked = false
        )
        ChatService.createMessage(2, message2)
        val updatedMessages = listOf(message1.copy(chatId = 1, id = 1), message2.copy(chatId = 2, id = 2))
        val getLastMessages = ChatService.getLastMessagesOfAllChats()
        assertEquals(updatedMessages, getLastMessages)
    }
}