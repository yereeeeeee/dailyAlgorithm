def two_pointer(left, right, value):
    current_value = arr[left] + arr[right]

    while left < right-1:
        if current_value == 0:
            return [arr[left], arr[right]]

        if abs(current_value) > value:
            return

        else:
            if current_value < 0:
                return two_pointer(left+1, right, abs(current_value))
            else:
                return two_pointer(left, right-1, abs(current_value))


    return [arr[left], arr[right]]

n = int(input())
arr = sorted(list(map(int, input().split())))
visited = [0] * n
print(*two_pointer(0, n-1, 1000000000))