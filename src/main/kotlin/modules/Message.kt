package modules

import data.MessageData
import interfaces.ChatCRUD

class Message : ChatCRUD<MessageData> {

    override val storage: List<MessageData>
        get() = storageIn
    var messageIdCount: Int = 0
    private val storageIn: MutableList<MessageData> = mutableListOf()


    override fun create(element: MessageData): Boolean {
        messageIdCount++
        val e = element.copy(id = messageIdCount)
        storageIn.add(e)
        return true
    }


    override fun update(element: MessageData): Boolean {
        for ((i, b) in storageIn.withIndex()) {
            if (element.id == b.id) {
                storageIn[i] = element
                println("The object has been updated!")
                return true
            }
        }
        println("Object not exist or wrong Id!")
        return false
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

}
