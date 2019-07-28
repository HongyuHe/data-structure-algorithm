object InsersionSortAlgo {

    def InsersionSort(array: Array[Double], n: Int): Array[Double] = {
        for (j <- 1 until n) {
            var key: Double = array(j)
            var i: Int = j - 1
            while (i >= 0 && array(i) > key) {
                array(i+1) = array(i)
                i -= 1
            }
            array(i+1) = key
        } 

        return array;
    }

    def main(args: Array[String]): Unit = {
        var array = Array(4234,234234,23,234,-134,4123,41,578,-342,55,0.2323,0.325)
        println("\nBefore sorting:")
        println(array.deep.mkString(" "))
        println("\nAfter sorting:")
        println(InsersionSort(array, array.length).deep.mkString(" "))
    } 

}