package services

import data.ChatData
import data.MessageData
import data.UserData
import modules.Chat
import modules.Message

object ChatService {

    private val chatCRUD: Chat = Chat(mutableListOf())
    private val messageCRUD: Message = Message(mutableListOf())
    private var checkCount = 0

    fun <E>MutableList<E>.makeDelete(mutableList: MutableList<E>){

    }

    fun getChats() = chatCRUD.read()

    fun getUnreadedChats() = checkCount

    fun deleteChat(id: Int, element: ChatData): Boolean {
        val messagesForChat = messageCRUD.getComments(MessageData(chatId = id))
        if (messageCRUD.storage.isNotEmpty()) {
            messagesForChat.forEach { it.isDeleted = true }
        }
        checkCount--
        return chatCRUD.delete(element.copy(id = id))
    }

    private fun getChatById(id: Int) = chatCRUD.read().first { it.id == id }


    fun createMessage(chatId: Int, element: MessageData): Boolean {
        val store = chatCRUD.storage
        if (!store.contains(ChatData(id = chatId)) || store.isEmpty()) {
            chatCRUD.create(ChatData(user = UserData(name = element.user.name, userID = element.user.userID)))
            checkCount++
            return messageCRUD.create(element.copy(chatId = chatId))
        }
        store.first { it.id == chatId && it.isDeleted }
            .let { return messageCRUD.create(element.copy(chatId = chatId)) }
    }


    fun readMessage(): MutableList<MessageData> = messageCRUD.read()

    fun getMessages(chatId: Int, element: MessageData): MutableList<MessageData> {
        return messageCRUD.getComments(element.copy(chatId = chatId))
    }

    fun getMessagesFromChat(userId: Int, element: MessageData): MutableList<MessageData> {
        return messageCRUD.getMessagesFromChat(userId, element)
    }


    fun updateMessage(messageId: Int, element: MessageData): Boolean {
        return messageCRUD.update(element.copy(id = messageId))
    }

    fun deleteMessage(messageId: Int, element: MessageData): Boolean {
        val chatToFind = getChatById(messageId)
        if (chatToFind.id == messageId) {
            checkCount--
            return messageCRUD.delete(element.copy(id = messageId))
        }
        return false
    }

}