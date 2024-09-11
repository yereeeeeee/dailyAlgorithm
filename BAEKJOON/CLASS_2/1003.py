def fib(x):
    global cnt_0, cnt_1
    if x == 0:
        cnt_0 += 1
        return 0
    elif x == 1:
        cnt_1 += 1
        return 1
    else:
        return fib(x-1) + fib(x-2)

T = int(input())

for _ in range(T):
    n = int(input())
    cnt_0 = 0
    cnt_1 = 0
    fib(n)
    print(cnt_0, cnt_1)