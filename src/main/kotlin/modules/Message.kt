package modules

import data.MessageData
import interfaces.ChatCRUD

class Message(
    override val storage: MutableList<MessageData>,
    var messageIdCount: Int = 0,
) : ChatCRUD<MessageData> {


    override fun create(element: MessageData): Boolean {
        messageIdCount++
        val e = element.copy(id = messageIdCount)
        storage.add(e)
        return true
    }


    override fun update(element: MessageData): Boolean {
        return super.update(element)
    }

    override fun delete(element: MessageData): Boolean {
        if (storage.isNotEmpty()) {
            storage.first { it.id == element.id }.isDeleted = true
            return true
        }
        return false
    }

    fun getComments(element: MessageData): MutableList<MessageData> {
        val message = mutableListOf<MessageData>()
        for ((i, b) in storage.withIndex())
            if (element.chatId == b.chatId) {
                message.add(b)
            }
        return message
    }

    fun getMessagesFromChat(userId: Int, element: MessageData): MutableList<MessageData> {
        val message = mutableListOf<MessageData>()
        for ((i, b) in storage.withIndex())
            if (userId == b.user.userID) {
                message.add(b)
            }
        return message
    }
}
