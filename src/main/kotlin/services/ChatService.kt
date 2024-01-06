package services

import data.ChatData
import data.MessageData
import modules.Chat
//import modules.Message

object ChatService {
    private val chatCRUD: Chat = Chat(mutableListOf())
//    private val messageCRUD: Message = Message(mutableListOf())

    fun createChat(element: ChatData)= chatCRUD.create(element)

    fun readChat() = chatCRUD.read()

//    fun updateChat(id:Int, element: ChatData): ChatData = chatCRUD.update(element.copy(id = id))

    fun deleteChat(id:Int, element: ChatData): Boolean  = chatCRUD.delete(element.copy(id=id))

//    fun createMessage(element: T) {
//        storage.add(element)
//    }
//
//    fun readMessage(): MutableList<MessageData> {
//        return messageCRUD
//    }
//
//    fun updateMessage(element: MessageData): MessageData {
//        return storage.first { it.id == element.id }
//    }
//
//    fun deleteMessage(element: MessageData): MessageData {
//        return storage.first { element.id == it.id  && element.isDeleted}
//    }
}