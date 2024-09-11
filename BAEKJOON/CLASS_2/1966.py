import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    n, m = map(int, input().split())
    num = list(map(int, input().split()))
    arr = list(enumerate(num))
    stack = []

    while len(num)>1:
        a = arr.pop(0)
        b = num.pop(0)

        if b == max(num):
            stack.append(a[0])
        else:
            arr.append(a)
            num.append(b)
    stack.append(arr[0][0])
    print(stack)
