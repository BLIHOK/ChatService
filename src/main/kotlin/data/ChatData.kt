package data

import interfaces.ChatLifeProp

data class ChatData(
    val title: String = "empty data.Chat",
    val data: Int = 2024,
    val user: User,
    override val id: Int,
    override val isDeleted: Boolean,

    ) : ChatLifeProp {

    data class User(
        val name: String = "noName",
        val userID: Int = 0
    )
}
