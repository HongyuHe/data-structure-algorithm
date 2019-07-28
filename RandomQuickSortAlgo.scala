class QuickSort() {

    protected var _array: Array[Double] = _

    def this(array: Array[Double]) {
        this()
        println(">> QuickSort Constructor called")

        this._array = array
    }
    
    def quickSort(start: Int, end: Int): Unit = {
        if (start < end) {
            var pivot_i = partition( start, end)

            quickSort(start, pivot_i-1)
            quickSort(pivot_i+1, end)
        }
    }

    protected def partition(start: Int, end: Int): Int = {
        var pivot = _array(end)
        var i = start - 1

        for (j <- start until end) {
            if (_array(j) < pivot) {
                i += 1
                // swap
                var tmp = _array(i)
                _array(i) = _array(j)
                _array(j) = tmp
            }
        }
        var tmp = _array(i+1)
        _array(i+1) = _array(end)
        _array(end) = tmp

        return i+1
    }

    def printArray {
        println(_array.deep.mkString(" "))
    }

}

class RandomQuickSort(val array: Array[Double]) extends QuickSort(array) {

    println("\nBefore sorting:")
    println(array.deep.mkString(" "))

    def randomPartition(start: Int, end: Int): Int = {
        val rand_tmp = new scala.util.Random
        val rand_i = start + rand_tmp.nextInt((end - start) + 1)

        var tmp = _array(rand_i)
        _array(rand_i) = _array(end)
        _array(end) = tmp

        return partition(start, end)
    }

    override def quickSort(start: Int, end: Int): Unit = {
        if (start < end) {
            var pivot_i = randomPartition(start, end)

            quickSort(start, pivot_i-1)
            quickSort(pivot_i+1, end)
        }
    }
}



object RandomQuickSortAlgo {

    def main(args: Array[String]): Unit = {
        val array = Array(4234,234234,23,234,-134,4123,41,578,-342,55,0.2323,0.325)
        val randomQuickSort = new RandomQuickSort(array)
        
        randomQuickSort.quickSort(0, array.length-1)
        println("\nAfter sorting:")
        randomQuickSort.printArray
    }
}