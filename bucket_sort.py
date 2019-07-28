import math

def insertion_sort(array, n):
    # print(array)
    for j in range(1, n):
        key = array[j]
        i = j - 1
        while i >= 0 and array[i] > key:
            array[i], array[i+1] = array[i+1], array[i]
            i -= 1
        array[i+1] = key
    # print(array)

def bucket_sort(array):
    ans = []
    n = len(array)
    bucket = [i[:] for i in [[]] * n]

    for i in range(n):
        bucket[math.floor(array[i] * n)].append(array[i])
    print(bucket)
    for j in range(n):  
        insertion_sort(bucket[j], len(bucket[j]))
    print(bucket)
    for i in range(n):
        ans.extend(bucket[i])
    print(ans)
    return ans



if __name__ == "__main__":
    array = [0.25, 0.49, 0.667, 0.41, 0.988, 0.456, 0.245, 0.565, 0.8277, 0.351, 0.12, 0.52, 0.51, 0, 0.93, 0.77]
    print("\nBefore sorting:", array)
    
    print("\nAfter sorting:", bucket_sort(array))