import data.MessageData
import data.UserData
import modules.Message
import services.ChatService

fun main() {

//    val chat1 = ChatData(
//        "New chat",
//        2024,
//        user = UserData("Igor", 0),
//        0,
//        false,
//        false
//    )
//    val chat2 = ChatData(
//        "2nd Chat",
//        2024,
//        user = User("Igor", 0),
//        0,
//        false  )

    val message1 = MessageData(
        "Hello",
        2024,
        user = UserData("Sergey", 0),
        chatId = 0,
        0,
        false,
        false
    )
//    val message2 = MessageData(
//        "How are you?",
//        2024,
//        user = UserData("Sergey", 0),
//        chatId = 0,
//        0,
//        false,
//        false
//    )
    val message3 = MessageData(
        "Im fine",
        2024,
        user = UserData("Alex", 1),
        chatId = 0,
        0,
        false,
        false
    )
    val updateMessage = MessageData(
        "Im updated Message",
        2024,
        user = UserData("Sergey", 0),
        chatId = 0,
        0,
        false,
        false
    )

    ChatService.createMessage(1, message1)
    ChatService.createMessage(1, message1)
    ChatService.createMessage(1, message1)
    ChatService.createMessage(2, message3)
    println(ChatService.getChats())
    println(ChatService.getUnreadChatsCount())
    println()


//    println(ChatService.getUserMessagesInChat(0, 1, 1))
//    println(ChatService.getUnreadChatsCount())
//    println(ChatService.getChats())
    println()
//    ChatService.deleteChat(1, ChatData())
//    println(ChatService.getChats())
    println(ChatService.getUserMessagesInChat(0, 3, 1))
    ChatService.updateMessage(1, updateMessage)
    println(ChatService.getUserMessagesInChat(0, 3, 1))
    println(ChatService.getUserMessagesInChat(1, 1, 2))
    ChatService.deleteMessage(1, MessageData())
    println(ChatService.getUserMessagesInChat(0, 3, 1))
    println()
    println(ChatService.getLastMessagesOfAllChats())
}
