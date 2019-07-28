def insertion_sort(array, n):
    for j in range(n):
        key = array[j]
        i = j - 1
        while i >= 0 and array[i] > key:
            array[i+1] = array[i]
            i -= 1
        array[i+1] = key

if __name__ == "__main__":
    array = [4234,234234,23,234,-134,4123,41,578,-342,55,0.2323,0.325]
    print("\nBefore sorting:", array)
    insertion_sort(array, len(array))
    print("\nAfter sorting:", array)