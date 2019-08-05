case class Node(var _key: Double = Double.PositiveInfinity, var _prev: Node = null, var _next: Node = null)

class LinkedList {
    private var _head: Node = null

    def listSearch(key: Double): Node = {
        var node = _head
        while (node != null && node._key != key) {
            node = node._next
        }
        return node
    }

    def listInsert(newNode: Node): Unit = {
        newNode._prev = null
        newNode._next = _head

        if (_head != null) {
            _head._prev = newNode
        }
        _head = newNode
    }

    def listDelete(node: Node): Unit = {
        if (node._prev != null) {
            node._prev._next = node._next
        } else {
            _head = node._next
        }

        if (node._next != null) {
            node._next._prev = node._prev
        }
    }

    override def toString(): String = {
        var list = "["
        var node = _head
        while (node != null) {
            list = list ++ " " ++ node._key.toString()
            node = node._next
        }
        return list ++ " ]"
    }
}

class SentinelLinkedList {
    private val _sentinel: Node = new Node()
    // Initialize _sentinel !!!
    _sentinel._prev = _sentinel
    _sentinel._next = _sentinel

    def listSearch(key: Double): Node = {
        // here should initialize node as _sentinel._next rather than _sentinel itself
        var node = _sentinel._next 
        while (node != _sentinel && node._key != key) {
            node = node._next
        }
        return node
    }

    def listInsert(newNode: Node): Unit = {
        newNode._prev = _sentinel
        newNode._next = _sentinel._next
        _sentinel._next._prev = newNode
        _sentinel._next = newNode
    }

    def listDelete(node: Node): Unit = {
        node._prev._next = node._next
        node._next._prev = node._prev
    }

    override def toString(): String = {
        var list = "<"
        var node = _sentinel._next
        while (node != _sentinel) {
            list = list ++ " " ++ node._key.toString()
            node = node._next
        }
        return list ++ " >"
    }
}

object DoublyLinkedListStructure {
    def main(args: Array[String]) = {
        // Test LinkedList:
        val linkedList = new LinkedList()
        println("New LinkedList: " ++ linkedList.toString)
        
        linkedList.listInsert(Node(10))
        linkedList.listInsert(Node(9))
        linkedList.listInsert(Node(8))
        linkedList.listInsert(Node(7))
        linkedList.listInsert(Node(6))
        linkedList.listInsert(Node(5))
        linkedList.listInsert(Node(4))
        linkedList.listInsert(Node(3))
        linkedList.listInsert(Node(2))
        linkedList.listInsert(Node(1))
        linkedList.listInsert(Node(0))
        println("After Insertion: " ++ linkedList.toString)

        linkedList.listDelete(linkedList.listSearch(0))
        linkedList.listDelete(linkedList.listSearch(8))
        linkedList.listDelete(linkedList.listSearch(9))
        linkedList.listDelete(linkedList.listSearch(10))
        println("After Delete: " ++ linkedList.toString)

        // Test SentinelLinkedList:
        val sentinelLinkedList = new SentinelLinkedList()
        println("New SentinelLinkedList: " ++ sentinelLinkedList.toString)

        sentinelLinkedList.listInsert(Node(10))
        sentinelLinkedList.listInsert(Node(9))
        sentinelLinkedList.listInsert(Node(8))
        sentinelLinkedList.listInsert(Node(7))
        sentinelLinkedList.listInsert(Node(6))
        sentinelLinkedList.listInsert(Node(5))
        sentinelLinkedList.listInsert(Node(4))
        sentinelLinkedList.listInsert(Node(3))
        sentinelLinkedList.listInsert(Node(2))
        sentinelLinkedList.listInsert(Node(1))
        sentinelLinkedList.listInsert(Node(0))
        println("After Insertion: " ++ sentinelLinkedList.toString)

        sentinelLinkedList.listDelete(sentinelLinkedList.listSearch(0))
        sentinelLinkedList.listDelete(sentinelLinkedList.listSearch(8))
        sentinelLinkedList.listDelete(sentinelLinkedList.listSearch(9))
        sentinelLinkedList.listDelete(sentinelLinkedList.listSearch(10))
        println("After Delete: " ++ sentinelLinkedList.toString)
    }
}