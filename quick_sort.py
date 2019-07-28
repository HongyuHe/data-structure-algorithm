def partition(array, start, end):
    pivot = array[end]
    i = start - 1

    for j in range(start, end):
        if array[j] <= pivot:
            i += 1
            array[i], array[j] = array[j], array[i]

    array[i+1], array[end] = array[end], array[i+1]

    return i+1

def quick_sort(array, start, end):
    if start < end:
        pivot_i = partition(array, start, end)

        quick_sort(array, start, pivot_i-1)
        quick_sort(array, pivot_i+1, end)

if __name__ == "__main__":
    array = [4234,234234,23,234,-134,123,41,578,-342,55,0.9323,0.325]
    # array = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0]

    print("Before sorting: ", array)
    quick_sort(array, 0, len(array)-1)
    print("After sorting:  ", array)
