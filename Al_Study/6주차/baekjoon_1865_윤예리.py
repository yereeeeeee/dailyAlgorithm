t = int(input())
for _ in range(t):
    n, m, w = map(int, input().split())
    for _ in range(2, m+2):     # 도로의 정보
        s, e, t = map(int, input().split())

    for _ in range(m+2, m+w+2): # 웜홀의 정보
        s, e, t = map((int, input().split()))


