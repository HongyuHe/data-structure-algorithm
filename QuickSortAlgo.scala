object QuickSortAlgo {

    def quickSort(array: Array[Double], start: Int, end: Int): Unit = {
        if (start < end) {
            var pivot_i = partition(array, start, end)

            quickSort(array, start, pivot_i-1)
            quickSort(array, pivot_i+1, end)
        }
    }

    def partition(array: Array[Double], start: Int, end: Int): Int = {
        var pivot = array(end)
        var i = start - 1

        for (j <- start until end) {
            if (array(j) < pivot) {
                i += 1
                // swap
                var tmp = array(i)
                array(i) = array(j)
                array(j) = tmp
            }
        }
        var tmp = array(i+1)
        array(i+1) = array(end)
        array(end) = tmp

        return i+1
    }

    def main(args: Array[String]): Unit = {
        var array = Array(4234,234234,23,234,-134,4123,41,578,-342,55,0.2323,0.325)
        println("\nBefore sorting:")
        println(array.deep.mkString(" "))

        quickSort(array, 0, array.length-1)

        println("\nAfter sorting:")
        println(array.deep.mkString(" "))
    }
}