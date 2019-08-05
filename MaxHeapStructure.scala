import scala.math._

class MaxHeap(array: Array[Double]) {

    private val _array = array
    private var _size  = array.length

    _buildMaxHeap_()
    private def _right_(i: Int): Int = i * 2
    private def _left_(i: Int): Int = i * 2 + 1
    private def _parent_(i: Int): Int = floor(i / 2).toInt
    override def toString: String = s"[Max Heap]: ${this._array.slice(0,_size).mkString(", ")}"

    private def _swap_(i: Int, j: Int) {
        var tmp = 0.0
        tmp = _array(i)
        _array(i) = _array(j)
        _array(j) = tmp
    }

    private def _buildMaxHeap_() {
        var i = 0
        for (i <- floor(_size / 2).toInt to 0 by -1) {
            _maxHeapify_(i)
        }
    }

    private def _maxHeapify_(i: Int) {
        val left = _left_(i)
        val right = _right_(i)
        var largest = i

        if (left < _size && _array(left) > _array(largest)) {
            largest = left
        }
        if (right < _size && _array(right) > _array(largest)) {
            largest = right
        }
        if (largest != i) {
            _swap_(i, largest)
            _maxHeapify_(largest)
        }
    }
    
    def maximum: Double = _array(0)

    def extractMax: Double = {
        var max = _array(0)
        _array(0) = _array(_size-1)
        _size -= 1
        _maxHeapify_(0)

        return max
    }

    def increaseKey(i: Int, key: Double) = {
        var index = i
        if (key < _array(index)) {
            throw new Exception("\nNew key is smaller than current key !\n")
        }
        _array(index) = key
        while (index > 0 && _array(index) > _array(_parent_(index))) {
            _swap_(index, _parent_(index))
            index = _parent_(index)
        }
    }

    def insert(key:Double) {
        _size += 1
        if (_size > _array.length) {
            _array :+ Double.NegativeInfinity
        } else {
            _array(_size-1) = Double.NegativeInfinity
        }
        increaseKey(_size-1, key)
    }

    def heapSort = {
        var i = 0
        var tmp = _size
        for (i <- _size-1 to 0 by -1) {
            _swap_(i, 0)
            _size -= 1
            _maxHeapify_(0)
        }
        _size = tmp
    }
}

object MaxHeapStructure {
    def main (args: Array[String]) : Unit = {
        // val array = Array(4234,3234,234234,23,234,-134,4123,41,578,-342,55,0.2323,0.325)
        val array = Array(0.0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val maxheap = new MaxHeap(array)

        println(s"Build Max Heap: $maxheap")
        println(s"Maximum: ${maxheap.maximum}")
        println(s"Extract Max: ${maxheap.extractMax}")
        println(s"After extraction: $maxheap")
        maxheap.insert(-11)
        println(s"After insertion: $maxheap")
        maxheap.increaseKey(3, 999999)
        println(s"After increasing key: $maxheap")
        maxheap.heapSort
        println(s"After heap sort: $maxheap")
    }
}