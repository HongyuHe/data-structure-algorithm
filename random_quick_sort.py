import random

def random_partition(array, start, end):
    rand_i = random.randint(start, end)
    array[rand_i], array[end] = array[end], array[rand_i]

    return partition(array, start, end)

def partition(array, start, end):
    pivot = array[end]
    i = start - 1

    for j in range(start, end):
        if array[j] <= pivot:
            i += 1
            array[i], array[j] = array[j], array[i]
    array[end], array[i+1] = array[i+1], array[end]

    return i+1

def random_quick_sort(array, start, end):
    if start < end:
        pivot_i = random_partition(array, start, end)

        random_quick_sort(array, start, pivot_i-1)
        random_quick_sort(array, pivot_i+1, end)


if __name__ == "__main__":
    array = [4234,234234,23,234,-134,123,41,578,-342,55,0.9323,0.325]
    # array = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0]

    print("Before sorting: ", array)
    random_quick_sort(array, 0, len(array)-1)
    print("After sorting:  ", array)