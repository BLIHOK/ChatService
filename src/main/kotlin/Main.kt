import data.ChatData
import data.MessageData
import data.UserData
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
    val message2 = MessageData(
        "How are you?",
        2024,
        user = UserData("Sergey", 0),
        chatId = 0,
        0,
        false,
        false
    )
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
        user = UserData("Alex", 1),
        chatId = 0,
        0,
        false,
        false
    )

    ChatService.createMessage(1, message1)
//    ChatService.getChats()
//    ChatService.readMessage()
    ChatService.createMessage(1, message2)
//    ChatService.readMessage()
//    ChatService.updateMessage(1, updateMessage)
    ChatService.createMessage(2, message1)
    ChatService.getChats()
    ChatService.readMessage()
//    ChatService.deleteMessage(1, MessageData())
//    ChatService.readMessage()
//    ChatService.getUnreadedChats()
//    println()
    ChatService.deleteChat(1, ChatData())
    ChatService.getChats()
    ChatService.readMessage()
    println(ChatService.getUnreadedChats())
    println(ChatService.getMessagesFromChat(0, MessageData()))
//
//    ChatService.createChat(chat2)
//    ChatService.deleteChat(chat2)
//    ChatService.readChat()
//    ChatService.getChatByUserId(0, ChatData())
//    ChatService.deleteChat(0, ChatData())
}


