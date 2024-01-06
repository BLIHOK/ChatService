package data

import interfaces.ChatLifeProp

data class MessageData(
    val text: String = "no text",
    val data: Int = 2024,
    val fromUser: String = " unknown",
    val isMessageChecked: Boolean,
    override val id: Int,
    override val isDeleted: Boolean
) : ChatLifeProp