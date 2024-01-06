import data.ChatData
import modules.Chat
import services.ChatService

fun main(args: Array<String>) {

    val chat1 = ChatData(
        "New chat",
        2024,
        ChatData.User("Igor", 0),
        0,
        false  )

    val chatUpdated = ChatData(
        "Updated chat",
        2024,
        ChatData.User("Igor", 0),
        0,
        false  )


    ChatService.createChat(chat1)
    println(ChatService.readChat())
    ChatService.deleteChat(0, ChatData())
    println(ChatService.readChat())
//    ChatService.deleteChat(0, ChatData())
}