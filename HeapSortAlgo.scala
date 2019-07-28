import scala.math._

class MaxHeap(val array: Array[Double]) {
    var _size:Int = array.length
    var _array:Array[Double]= array

    // def swapVals_(a: Double, b: Double) {
    //     var tmp = 0.0
    //     tmp = a
    //     a = b
    //     b = tmp
    // }

    def leftNode(i: Int): Int = {
        if (i == 0) {
            return 1;
        } else {
            return i * 2;
        }
    }

    def rightNode(i: Int): Int = {
        if (i == 0) {
            return 2;
        } else {
            return i * 2 + 1;
        }
    }

    def maxHeapify(i: Int) {
        var left_i : Int = leftNode(i)
        var right_i: Int = rightNode(i)
        var largest = i

        if (left_i < _size && _array(left_i) > _array(i)) {
            largest = left_i
        }
        if (right_i < _size && _array(right_i) > _array(largest)) {
            largest = right_i
        }
        if (largest != i) {
            var tmp = 0.0
            tmp = _array(largest)
            _array(largest) = _array(i)
            _array(i) = tmp

            maxHeapify(largest)
        }
    }

    def buildMaxHeap() {
        var i: Int = 0
        for(i <- (floor(_size / 2)).asInstanceOf[Int] to 0 by -1) {
            maxHeapify(i)
        }
    }

    def heapSort() {
        buildMaxHeap()

        val i: Int = 0
        for (i <- (_array.length-1) to 1 by -1) {
            var tmp = 0.0
            tmp = _array(i)
            _array(i) = _array(0)
            _array(0) = tmp

            _size -= 1
            maxHeapify(0)
        }
    }
}

object HeapSortAlgo {
    def main(args: Array[String]): Unit = {
        var array = Array(4234,234234,23,234,-134,4123,41,578,-342,55,0.2323,0.325)
        val maxHeap = new MaxHeap(array)
        println("\nBefore sorting:")
        println(maxHeap._array.deep.mkString(" "))
        maxHeap.heapSort()
        println("\nAfter sorting:")
        println(maxHeap._array.deep.mkString(" "))
    } 
}