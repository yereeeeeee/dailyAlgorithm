import sys
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [[1e8] * n for _ in range(n)]
next_node = [[0] * n for _ in range(n)]

for i in range(n):
    graph[i][i] = 0

for _ in range(m):
    a, b, cost = map(int, input().split())
    a -= 1
    b -= 1
    if cost < graph[a][b]:
        graph[a][b] = graph[b][a] = cost
        next_node[a][b] = b
        next_node[b][a] = a

# 거쳐가는 노드
for k in range(n):
    # 출발 노드
    for i in range(n):
        # 도착 노드
        for j in range(n):
            if graph[i][j] > graph[i][k] + graph[k][j]:
                graph[i][j] = graph[i][k] + graph[k][j]
                next_node[i][j] = next_node[i][k]

for i in range(n):
    answer = []
    for j in range(n):
        if i == j:
            answer.append("-")
        else:
            answer.append(str(next_node[i][j] + 1))

    print(" ".join(answer))