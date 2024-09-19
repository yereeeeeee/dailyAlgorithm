import sys
input = sys.stdin.readline

n = int(input())
if n == 1: exit(print(1))
boxes = list(map(int, input().split()))
answer = 0
dp = [1] * n

for i in range(n):
    for j in range(i):


print(answer)