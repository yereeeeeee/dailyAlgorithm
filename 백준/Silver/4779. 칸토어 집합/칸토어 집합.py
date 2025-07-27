def cut(a, n):
    if n < 3:
        return

    third = n // 3

    for i in range(a + third, a + 2 * third):
        arr[i] = " "

    cut(a, third)
    cut(a + 2 * third, third)

try:
    while True:
        n = int(input())
        arr = ["-"] * (3 ** n)
        cut(0, 3 ** n)
        print("".join(arr))
except EOFError:
    pass
