N = int(input())
A = sorted(list(map(int, input().split())))
M = int(input())
m = list(map(int, input().split()))

def find(key, A):
    start = 0
    end = M-1
    while start <= end:
        mid = (start + end) // 2
        if A[mid] == key:
            return 1
        elif A[mid] < key:
            start = mid + 1
        else:
            end = mid - 1
    return 0

for k in m:
    if A[0] <= k <= A[-1]:
        print(find(k, A))
    else:
        print(0)