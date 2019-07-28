def count_sort(array, array_buf, max_val):
    counter = [0] * (max_val + 1)

    for i in range(len(array)):
        counter[array[i]] += 1
    print(counter)
    for j in range(1, len(counter)):
        counter[j] += counter[j-1]
    print(counter)
    for i in range(len(array)-1, -1,-1):
        array_buf[counter[array[i]]] = array[i]
        counter[array[i]] -= 1
    print(array_buf)

    return array_buf[1:] 
    # we didn't use the first element so we do a slicing here


if __name__ == "__main__":
    array = [5, 10, 9, 1, 8, 5, 6, 0, 0, 0, 5, 8, 10, 3, 2, 1, 5, 8]
    array_buf = [0] * (len(array)+1)    
    ''' we don't use [0] slot so we start from [1] 
    so consequemtly, we need (len()+1) slots''' 

    print("Before sorting: ", array)
    array_sorted = count_sort(array, array_buf, 10)
    print("After sorting:  ", array_sorted)



