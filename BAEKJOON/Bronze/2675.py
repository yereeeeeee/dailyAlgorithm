T = int(input())
for t in range(T):
    R, S = map(str, input().split())
    list(S)
    for s in S:
        print(s * int(R), end='')
    print()