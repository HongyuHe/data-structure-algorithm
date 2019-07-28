import math

class MaxHeap:
    def __init__(self, array):
        self.array = array
        self.size = len(array)

    def _left_node_(self, i):   # no matter use self or not, self argument is inevitable;
        if i == 0:
            return 1
        else:
            return i * 2

    def _right_node_(self, i):
        if i == 0:
            return 2
        else:
            return i * 2 + 1

    def _parent_node_(self, i):
        return math.floor(i / 2)

    def _max_heapify_(self, i):
        left_i  = self._left_node_(i)
        right_i = self._right_node_(i)

        if left_i < self.size and self.array[i] < self.array[left_i]:
            largest = left_i
        else:
            largest = i
        
        if right_i < self.size and self.array[largest] < self.array[right_i]:
            largest = right_i
        
        if largest != i:
            self.array[i], self.array[largest] = self.array[largest], self.array[i]
            self._max_heapify_(largest)
        
    def _build_max_heap_(self):
        for i in range(math.floor(self.size / 2), -1, -1):
            self._max_heapify_(i)

    def heap_sort(self):
        self._build_max_heap_() # build the initial max-heap
        for i in range(len(self.array)-1, 0, -1):
            self.array[i], self.array[0] = self.array[0], self.array[i]
            self.size -= 1
            print("Sorting: ", self.array)
            self._max_heapify_(0)

    
if __name__ == "__main__":
    # array = [4234,234234,23,234,-134,123,41,578,-342,55,0.9323,0.325]
    array = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
    max_heap = MaxHeap(array)
    print("Before sorting: ", max_heap.array)
    max_heap.heap_sort()
    print("After sorting:  ", max_heap.array)