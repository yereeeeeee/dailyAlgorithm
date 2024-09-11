import sys
input = sys.stdin.readline

n, k = map(int, input().split())
tmp = list(map(int, input().split()))
arr = [tmp[:n], tmp[2*n-1:n-1:-1]]

while arr.count(0) < k:
