//package modules
//
//import data.MessageData
//import interfaces.ChatCRUD
//
//class Message(
//    override val storage: MutableList<MessageData>
//) : ChatCRUD<MessageData> {
//    override fun create(element: MessageData) {
//        storage.add(element)
//    }
//
//    override fun read(): MutableList<MessageData> {
//        return super.read()
//    }
//
//    override fun update(element: MessageData): MessageData {
//        return super.update(element)
//    }
//
//    override fun delete(element: MessageData): MessageData {
//        return super.delete(element)
//    }
//}