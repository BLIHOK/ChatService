package data

import interfaces.ChatLifeProp

data class ChatData(
    val title: String = "a new Chat",
    val data: Int = 2024,
    val user: UserData = UserData(),
    override var id: Int = 0,
    override var isDeleted: Boolean = false,
    override var isChecked: Boolean = false
    ) : ChatLifeProp


