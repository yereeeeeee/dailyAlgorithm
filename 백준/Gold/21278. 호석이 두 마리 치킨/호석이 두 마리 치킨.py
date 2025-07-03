import sys
input = sys.stdin.readline

n, m = map(int, input().split())

dist = [[1e8] * (n+1) for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    dist[a][b] = 1
    dist[b][a] = 1

# 본인 자리 거리는 0
for i in range(n+1):
    for j in range(n+1):
        if i == j:
            dist[i][j] = 0

# 플로이드 워셜
for k in range(n+1):          # 거치는 점
    for i in range(n+1):      # 시작점
        for j in range(n+1):  # 끝점
            # i를 거쳤을 때의 경로가 더 적은 경로
            if dist[i][j] > dist[i][k] + dist[k][j]:
                dist[i][j] = dist[i][k] + dist[k][j]

best1 = -1
best2 = -1
min_total = 1e8

# 조합해서 최단 거리 갱신
for i in range(1, n+1):
    for j in range(i+1, n+1):
        total = 0

        for k in range(1, n+1):
            total += (min(dist[k][i], dist[k][j]) * 2)
        
        if total < min_total:
            min_total = total
            best1 = i
            best2 = j

print(best1, best2, min_total)

