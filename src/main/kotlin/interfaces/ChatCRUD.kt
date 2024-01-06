package interfaces

interface ChatCRUD<T : ChatLifeProp> {
    val storage: MutableList<T>

    fun create(element: T) {
        storage.add(element)
    }

    fun read(): MutableList<T> {
        return storage
    }

    fun update(element: T): T {
        return storage.first { it.id == element.id }
    }

    fun delete(element: T): Boolean {
//        storage.first { element.id == it.id  && element.isDeleted}
        return this.storage[element.id].isDeleted
    }

}