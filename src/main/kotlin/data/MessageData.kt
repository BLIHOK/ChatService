package data

import interfaces.ChatLifeProp

data class MessageData(
    val text: String = "no text",
    val data: Int = 2024,
    val user: UserData = UserData(),
    val chatId: Int = 0,
    override var id: Int = 0,
    override var isDeleted: Boolean = false,
    override val isChecked: Boolean = false
) : ChatLifeProp