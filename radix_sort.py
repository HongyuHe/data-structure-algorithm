def extra_key(num, key_digit):
    radix = 10
    if key_digit == 1:
        return num % radix
    else:
        return num % (radix**key_digit) // (radix**(key_digit - 1))

def count_sort(array, array_buf, max_val, key_digit):
    counter = [0] * (max_val + 1)

    for i in range(len(array)):
        counter[extra_key(array[i], key_digit)] += 1
    for j in range(1, len(counter)):
        counter[j] += counter[j-1]
    for i in range(len(array)-1, -1, -1):
        array_buf[counter[extra_key(array[i], key_digit)]] = array[i]
        counter[extra_key(array[i], key_digit)] -= 1
    return array_buf[1:]

def radix_sort(array, digit_num):
    radix = 10
    for i in range(1, digit_num+1):
        array_buf = [0] * (len(array)+1)
        array = count_sort(array, array_buf, radix-1, i)
    return array

if __name__ == "__main__":
    array = [1034, 2240, 1400, 1000, 3498, 6537, 5263, 8628, 4567, 5888, 7777]
    print("Before sorting: ", array)

    print('After sorting: ', radix_sort(array, 4))