import sys
input = sys.stdin.readline

n, m = map(int, input().split())
stations = list(map(int, input().split()))

prv = [0 for _ in range(1000000+1)]
nxt = [0 for _ in range(1000000+1)]

for i in range(n):
    now_station_num = stations[i]
    prv[now_station_num] = stations[i-1]
    nxt[now_station_num] = stations[(i+1)%n]

def insert(b, d):
    c = nxt[b]
    nxt[b] = d
    prv[d], nxt[d] = b, c
    prv[c] = d

def remove(b):
    a, c = prv[b], nxt[b]
    nxt[a], prv[c] = c, a

for _ in range(m):
    command = list(input().split())
    info = command[0]

    if info == "BN":
        i, j = int(command[1]), int(command[2])
        print(nxt[i])
        insert(i, j)
    elif info == "BP":
        i, j = int(command[1]), int(command[2])
        print(prv[i])
        insert(prv[i], j)
    elif info == "CN":
        i = int(command[1])
        print(nxt[i])
        remove(nxt[i])
    else:
        i = int(command[1])
        print(prv[i])
        remove(prv[i])

                