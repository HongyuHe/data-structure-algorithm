import math

class MaxHeap:
    def __init__(self, array):
        self.array = array
        self.size  = len(array)

        self._build_max_heap_()

    def __str__(self):
        return str(self.array[:self.size]).strip('[]')
    
    def _left_(self, i):
        return i * 2
    def _right_(self, i):
        return i * 2 + 1
    def _parent_(self, i):
        return i // 2 
    
    def _build_max_heap_(self):
        for i in range(math.floor(len(self.array) / 2), -1, -1):
            self.maxheapify(i)

    def maxheapify(self, parent): # top-down approach
        left  = self._left_(parent)
        right = self._right_(parent)

        largest = parent
        if left < self.size and self.array[left] > self.array[largest]: # ??? 
            largest = left
        if right < self.size and self.array[right] > self.array[largest]:
            largest = right
        if largest != parent:
            # make sure that the root (array[i]) is now greater than all its childrens
            self.array[parent], self.array[largest] = self.array[largest], self.array[parent]
            self.maxheapify(largest) 
            ''' 
            After exchange, the node with 'largest' index is no longer 
            the largest element (smaller than before) so we need to use maxheapify()
            to guarrantee its max-heap property
            '''

    def maximum(self):
        return self.array[0]

    def extract_max(self):
        max = self.array[0]
        self.array[0] = self.array[self.size-1]
        self.size -= 1
        self.maxheapify(0)

        return max

    def increase_key(self, i, key):
        ''' 
        We have to make sure the key value is greater than its original value 
        because this is an upwards method which means we assume the key is greater than
        all the values of nodes that below i
        '''
        if self.array[i] > key:
            raise ValueError("New key is smaller than current key !")

        self.array[i] = key
        while i >= 0 and self.array[i] > self.array[self._parent_(i)]:
            self.array[i], self.array[self._parent_(i)] \
                = self.array[self._parent_(i)], self.array[i]
            i = self._parent_(i) 
    
    def insert(self, key):
        self.size += 1
        if self.size > len(self.array):
            self.array.append(-float("inf"))
        else:
            self.array[self.size-1] = -float('inf')
        self.increase_key(self.size-1, key)

    def heap_sort(self):
        size_ = self.size
        for i in range(self.size-1, -1, -1):
            self.array[0], self.array[i] = self.array[i], self.array[0]
            self.size -= 1
            self.maxheapify(0)
        self.size = size_

if __name__ == "__main__":
    # array = [4234,23,231412,234,-134,123,41,578,-342,55,0.9323,0.325]
    array = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    maxheap = MaxHeap(array)
    print('Build Max Heap: ', maxheap)
    print('Maximum: ', maxheap.maximum())
    maxheap.insert(-11)
    print('After insertion: ', maxheap)
    maxheap.increase_key(3, 99999999)
    print('After increasing key: ', maxheap)
    print('Extract: ', maxheap.extract_max())
    print('After Extraction: ', maxheap)
    maxheap.heap_sort()
    print('After HeapSort: ', maxheap)