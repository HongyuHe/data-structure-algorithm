object CountSortAlgo {
    def CountSort(array: Array[Int], arrayBuf: Array[Int], max: Int): Array[Int] = {
        val counter = Array.fill[Int](max+1)(0)

        var i:Int = 0
        for (i <- 0 until array.length) {
            counter(array(i)) += 1
        }
        println(s"\nCounter: ${counter.deep.mkString(" ")}")
        for (i <- 1 until counter.length) {
            counter(i) += counter(i-1)
        }
        println(s"\nCounter: ${counter.deep.mkString(" ")}")
        for (i <- (array.length-1) to 0 by -1) {
            arrayBuf(counter(array(i))) = array(i)
            counter(array(i)) -= 1
        }
        return arrayBuf.slice(1, arrayBuf.length)

    }

    def main(args: Array[String]): Unit = {
        val array = Array(5, 10, 9, 1, 8, 5, 6, 0, 0, 0, 5, 8, 10, 3, 2, 1, 5, 8)
        val arrayBuf = Array.fill[Int](array.length+1)(0)

        println(s"\nBefore sorting: ${array.deep.mkString(" ")}")        
        println(s"\nAfter sorting: ${CountSort(array, arrayBuf, 10).deep.mkString(" ")}")
    }
}