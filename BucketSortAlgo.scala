import scala.collection.mutable.ArrayBuffer
import scala.math._


object BucketSortAlgo {

    def insertionSort(array: Array[Double], n: Int) : Array[Double] = {
        for (j <- 1 until n) {
            var key = array(j)
            var i = j - 1
            while (i >= 0 && array(i) > key) {
                array(i+1) = array(i)
                i -= 1
            }
            array(i+1) = key
        }
        return array
    }

    def bucketSort(array: Array[Double]): ArrayBuffer[Double] = {
        val bucket_num = array.length
        val bucket = ArrayBuffer.fill[Double](bucket_num, 0)(0)
        val result = ArrayBuffer[Double]()

        var i = 0
        for (i <- 0 until bucket_num) {
            // collection.mutable.ArrayBuffer(bucket(floor(array(i)).asInstanceOf[Int]): _*) += array(i)
            bucket(floor(array(i)).toInt) += array(i)
        }
        for (i <- 0 until bucket_num) {
            bucket(i) = insertionSort(bucket(i).to[Array], bucket(i).length).to[ArrayBuffer]
        }
        for (i <- 0 until bucket_num) {
            result ++= bucket(i)
        }
        return result
    }

    def main(args: Array[String]): Unit = {
        var array = Array(0.25, 0.49, 0.667, 0.41, 0.988, 0.456, 0.245, 0.565, 0.8277, 0.351, 0.12, 0.52, 0.51, 0, 0.93, 0.77)
        println("\nBefore sorting:")
        println(array.mkString(" "))
        println("\nAfter sorting:")
        println(bucketSort(array).mkString(" "))
    }
}