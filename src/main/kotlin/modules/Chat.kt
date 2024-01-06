package modules

import data.ChatData
import interfaces.ChatCRUD

class Chat(
    override val storage: MutableList<ChatData>
) :ChatCRUD<ChatData>