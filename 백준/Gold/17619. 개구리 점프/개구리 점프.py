import sys

# find : 현재 x의 parent를 리턴하는 함수
def find(x):
    if x == parent[x]:
        return x
    # 경로 압축
    parent[x] = find(parent[x])
    return parent[x]

# union : x와 y를 같은 집합으로 묶는 함수
def union(x, y):
    x = find(x)
    y = find(y)
    parent[y] = x

# 입력부
n, q = map(int, sys.stdin.readline().split())
arr = []
for i in range(n):
    a,b,c = map(int, sys.stdin.readline().split())
    arr.append((a,b,c,i))
    
# 시작점 기준으로 오름차순 정렬
arr.sort()

# parent : i번의 부모번호를 저장하는 리스트
parent = [i for i in range(n)]

# now_start, now_end, now_idx : 현재 시작점, 현재 끝점, 현재 인덱스
now_start, now_end, _, now_idx = arr[0]
for i in range(1, n):
    # next_start, next_end, next_idx : 다음 시작점, 다음 끝점, 다음 인덱스
    next_start, next_end, _, next_idx = arr[i]
    
    # 겹치는 조건 확인
    if now_start <= next_start <= now_end:
        # 같은 집합으로 묶기
        union(now_idx, next_idx)
        
        # 갱신조건 확인 (끝점이 더 멀어질 수 있는 경우)
        if next_end >= now_end:
            now_start, now_end, now_idx = next_start, next_end, next_idx
            
    # 갱신조건 (겹치지 않는 경우)
    else:
        now_start, now_end, now_idx = next_start, next_end, next_idx
        
 
for _ in range(q):
    a, b = map(int, sys.stdin.readline().split())
    # 만일 a와 b의 부모가 같다면 같은 집합, 그렇지 않다면 다른 집합
    if parent[a - 1] == parent[b - 1]:
        print(1)
    else:
        print(0)