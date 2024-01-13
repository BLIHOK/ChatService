package interfaces

interface ChatCRUD<T : ChatLifeProp> {
    val storage: MutableList<T>

    fun create(element: T):Boolean {
        storage.add(element)
        return true
    }

    fun read(): MutableList<T> {
        println(storage)
        return storage
    }

    fun update(element: T): Boolean {
        for ((i, b) in storage.withIndex()) {
            if (element.id == b.id) {
                storage[i] = element
                println("The object has been updated!")
                return true
            }
        }
        println("Object not exist or wrong Id!")
        return false
    }

    fun delete(element: T): Boolean {
        return this.storage[element.id].isDeleted
    }

}