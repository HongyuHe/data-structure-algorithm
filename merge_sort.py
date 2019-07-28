import sys

def MergeSort(array, start, end):
    if start < end:
        mid = (start + end) // 2

        MergeSort(array, start, mid)
        MergeSort(array, mid+1, end)

        Merge(array, start, mid, end)    

def Merge(array, start, mid, end):
    # len_l = mid - start + 1
    # len_r = end - mid

    array_left = array[start: mid+1]
    array_right = array[mid+1: end+1]
    print("right: {}, left: {}".format(array_left, array_right))
    
    inf = sys.maxsize
    array_left.append(inf)
    array_right.append(inf)

    i, j = 0, 0
    for k in range(start, end+1):
        print(array)
        print("Compare left[{}]:{} with right[{}]:{}".format(i, array_left[i], j, array_right[j]))
        print()
        if array_left[i] <= array_right[j]:
            array[k] = array_left[i]
            i += 1
        else:
            array[k] = array_right[j]
            j += 1

if __name__ == "__main__":
    array = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
    # array = [4234,234234,23,234,-134,123,41,578,-342,55,0.9323,0.325]
    end = len(array) - 1

    print("Before sorting: ", array)
    MergeSort(array, 0, end)
    print("After sorting: ", array)






