package interfaces

interface ChatCRUD<T : ChatLifeProp> {
    val storage: List<T>

    fun create(element: T)

    fun update(element: T): Boolean

    fun delete(element: T) : Boolean

    fun clear()
}