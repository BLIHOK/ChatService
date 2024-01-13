package modules

import data.ChatData
import interfaces.ChatCRUD

class Chat(
    override val storage: MutableList<ChatData>,
    var chatIdCount: Int = 0,
) : ChatCRUD<ChatData> {

    override fun create(element: ChatData): Boolean {
        chatIdCount++
        val e = element.copy(id = chatIdCount)
        storage.add(e)
        return true
    }


    override fun delete(element: ChatData): Boolean {
        if(storage.isNotEmpty()) {
            storage.first{it.id == element.id}.isDeleted = true
            return true
        }
        return false
    }


    fun getUnreadedChats(): MutableList<ChatData> {
        val unreadedChat = mutableListOf<ChatData>()
        storage.forEach {
            if (it.isChecked == false) unreadedChat.add(it)
        }
        println(unreadedChat)
        return unreadedChat
    }

//    fun getChatByUserId(id: Int): ChatData {
//        return storage.first { it.user.userID == id }
//    }
}