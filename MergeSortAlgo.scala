object MergeSortAlgo {
    def Merge(array: Array[Double], start: Int, mid: Int, end: Int): Unit = {
        var len_l = mid - start + 1
        var len_r = end - mid

        printf("start: %d, mid: %d, end: %d\n", start, mid, end)
        var i, j = 0
        var array_left  = new Array[Double](len_l)
        var array_right = new Array[Double](len_r)
        for (i <- 0 until len_l) {
            array_left(i) = array(start+i)
        } 
        for (j <- 0 until len_r) {
            array_right(j) = array(mid+j+1)
        }

        array_left  :+= Double.MaxValue
        array_right :+= Double.MaxValue
        println("L: ", array_left.deep.mkString(" | "))
        println("R: ", array_right.deep.mkString(" | "))

        i = 0
        j = 0
        var k = 0
        for (k <- start to end) {
            // printf("start: %d, end: %d, i: %d, j: %d, k: %d\n", start, end, i, j, k)
            if (array_left(i) <= array_right(j)) {
                array(k) = array_left(i)
                i += 1
            } else {
                array(k) = array_right(j)
                j += 1
            }
            println(array.deep.mkString(" | "))
        }
    }

    def MergeSort(array: Array[Double], start: Int, end: Int): Array[Double] = {
        if (start < end) {
            var mid = (start + end) / 2

            MergeSort(array, start, mid)
            MergeSort(array, mid+1, end)

            Merge(array, start, mid, end)
        }
        return array
    }

    def main(args: Array[String]): Unit = {
        var array = Array(9999, 4234,234234,23,234,-134,4123,41,578,-342,55,0.2323,0.325)
        println("\nBefore sorting:")
        println(array.deep.mkString(" | "))
        println("\nAfter sorting:")
        println(MergeSort(array, 0, array.length-1).deep.mkString(" | "))
    } 
}
