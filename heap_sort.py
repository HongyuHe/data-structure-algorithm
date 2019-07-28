import math

def LeftNode(i):
    if i == 0:
        return 1
    else:
        return i * 2

def RightNode(i):
    if i == 0:
        return 2
    else:
        return i * 2 + 1

def ParentNode(i):
    return math.floor(i / 2)

def MaxHeapify(array, heap_size, i):
    left_i  = LeftNode(i)
    right_i = RightNode(i)

    if left_i < heap_size and array[i] < array[left_i]:
        largest = left_i
    else:
        largest = i
    
    if right_i < heap_size and array[largest] < array[right_i]:
        largest = right_i
    
    if largest != i:
        array[i], array[largest] = array[largest], array[i]
        MaxHeapify(array, heap_size, largest)
    
def BuildMaxHeap(array):
    heap_size = len(array)
    for i in range(math.floor(len(array)/2), -1  , -1):
        # print("Build MaxHeapify: ", i)
        MaxHeapify(array, heap_size, i)

def HeapSort(array):
    heap_size = len(array)
    BuildMaxHeap(array) # build the initial max-heap
    # print("Max initial heap top: ", array[0])
    for i in range(len(array)-1, 0, -1):
        # print("HeapSort: ", i)
        array[i], array[0] = array[0], array[i]
        heap_size -= 1
        print("Sorting: ", array)
        MaxHeapify(array, heap_size, 0,)
        # print("Max heap top: ", array[0])

    
if __name__ == "__main__":
    array = [4234,234234,23,234,-134,123,41,578,-342,55,0.9323,0.325]
    # array = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
    print("Before sorting: ", array)
    HeapSort(array)
    print("After sorting:  ", array)