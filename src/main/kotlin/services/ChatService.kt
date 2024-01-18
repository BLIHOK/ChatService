package services

import data.ChatData
import data.MessageData
import data.UserData
import modules.Chat
import modules.Message

object ChatService {
    private val chatCRUD: Chat = Chat()
    private val messageCRUD: Message = Message()

    fun getChats() = chatCRUD.storage //+

    fun getUnreadChatsCount(): Map<Int, Int> { /// получаем 2 числа: число непрочитанных чатов и число непрочитанных сообщений
        val checkedChat = chatCRUD.storage.filter { !it.isChecked }.map { it.id }
        val checkedMessages = messageCRUD.storage
            .filter { !it.isChecked && it.chatId in checkedChat }
            .groupBy { it.chatId }
            .map { it.key to it.value.count() }
            .toMap()
        println("Unreaded: Chat / Messages")
        return checkedMessages
    }


    fun getUserMessagesInChat(userId: Int, countOfMsg: Int, chatId: Int): List<MessageData> {
        val findChat = chatCRUD.storage.first { it.id == chatId }.id
        val listOfUserMsg = messageCRUD.storage.filter { it.user.userID == userId && chatId == findChat }

        if (countOfMsg in 0..listOfUserMsg.size) {
            val lastMsg = listOfUserMsg.take(countOfMsg)
            lastMsg.forEach { it.isChecked = true }
            chatCRUD.storage.filter { it.id == chatId }.map { it.isChecked = true }
            return lastMsg
        }
        return listOfUserMsg
    }

    fun deleteChat(id: Int, element: ChatData): Boolean {
        val messagesForChat = messageCRUD.getComments(MessageData(chatId = id))
        if (messageCRUD.storage.isNotEmpty()) {
            messagesForChat.forEach { it.isDeleted = true }
        }
        return chatCRUD.delete(element.copy(id = id))
    }


    fun createMessage(chatId: Int, element: MessageData) {
        val store = chatCRUD.storage
        if (store.isEmpty() || store.none { it.id == chatId }) {
            chatCRUD.create(ChatData(user = UserData(name = element.user.name, userID = element.user.userID)))

            messageCRUD.create(element.copy(chatId = chatId))
        }else messageCRUD.create(element.copy(chatId = chatId))
    }

    fun updateMessage(messageId: Int, element: MessageData): Boolean = messageCRUD.update(element.copy(id = messageId))

    fun deleteMessage(messageId: Int, element: MessageData): Boolean {
        val chatToFind = messageCRUD.storage.first { it.id == messageId }
        if (chatToFind.id == messageId) {
            return messageCRUD.delete(element.copy(id = messageId))
        }
        return false
    }

    fun getLastMessagesOfAllChats(): List<MessageData> {
        return messageCRUD.storage.distinctBy { it.chatId }
    }
    fun clear() {
        chatCRUD.clear()
        messageCRUD.clear()
    }
}