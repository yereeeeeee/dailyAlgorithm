import sys
input = sys.stdin.readline

n = int(input())
nodes = []

for i in range(n):
    x, y, z = map(int, input().split())
    nodes.append((x, y, z, i))

edges = []

# 각 축에 대해 정렬 후 인접 노드만 간선 생성
for dim in range(3):
    nodes.sort(key=lambda x: x[dim])
    for i in range(n - 1):
        a = nodes[i][3]
        b = nodes[i + 1][3]
        cost = abs(nodes[i][dim] - nodes[i + 1][dim])
        edges.append((cost, a, b))

# 크루스칼
edges.sort()
par = [i for i in range(n)]

def find(x):
    if par[x] != x:
        par[x] = find(par[x])
    return par[x]

def union(x, y):
    x = find(x)
    y = find(y)
    if x != y:
        par[y] = x

answer = 0
for cost, a, b in edges:
    if find(a) != find(b):
        union(a, b)
        answer += cost

print(answer)
