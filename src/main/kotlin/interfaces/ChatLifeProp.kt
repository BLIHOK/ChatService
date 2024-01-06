package interfaces

interface ChatLifeProp {
    val id: Int
        get() = 0
    val isDeleted: Boolean
        get() = false
}