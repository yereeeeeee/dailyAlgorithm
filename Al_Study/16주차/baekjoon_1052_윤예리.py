import sys
input = sys.stdin.readline

n, k = map(int, input().split())
cnt = 0

while bin(n).count('1') > k:
    idx = reversed(bin(n)).index('1')
    n += 2 ** idx
    cnt += 2 ** idx

print(cnt)