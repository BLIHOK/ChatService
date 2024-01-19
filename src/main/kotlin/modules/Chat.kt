package modules

import data.ChatData
import interfaces.ChatCRUD

class Chat : ChatCRUD<ChatData> {

    override val storage: List<ChatData>
        get() = storageIn
    private var chatIdCount: Int = 0
    private val storageIn: MutableList<ChatData> = mutableListOf()

    override fun clear() {
        storageIn.clear()
        chatIdCount = 0

    }

    override fun create(element: ChatData) {
        chatIdCount++
        val e = element.copy(id = chatIdCount)
        storageIn.add(e)

    }

    override fun update(element: ChatData): Boolean  = true

    override fun delete(element: ChatData): Boolean {
        if (storage.isNotEmpty()) {
            storage.first { it.id == element.id }.isDeleted = true
            return true
        }
        return false
    }

}