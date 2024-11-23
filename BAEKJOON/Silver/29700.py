import sys
input = sys.stdin.readline

n, m, k = map(int, input().split())
arr = [list(input().strip()) for _ in range(n)]
answer = 0

for i in range(n):
    for j in range(m):
        if arr[i][j] == "0":
            if j + k > m:
                break

            for x in range(k):
                if arr[i][j+x] == "1":
                    break
            else:
                answer += 1

print(answer)