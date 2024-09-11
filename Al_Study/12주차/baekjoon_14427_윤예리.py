# 세그먼트 트리
import sys
input = sys.stdin.readline
import math

# 세그먼트 트리 초기화 함수
def init(start, end, index):
    # 이분 탐색
    if start == end:
        tree[index] = arr[start]
    else:
        mid = (start+end)//2
        # 자식 노드의 최솟값을 tree에 저장해준다.
        tree[index] = min(init(start, mid, index*2), init(mid+1, end, index*2+1))
    return tree[index]

# 세그먼트 트리 업데이트 함수
def update(start, end, index, w, v):
    if w < start or w > end:
        return
    # 자식 노드 도달 > 업데이트 후 종료
    if start == end:
        tree[index] = v
        return tree[index]
    mid = (start+end)//2
    update(start, mid, index*2, w, v)
    update(mid+1, end, index*2+1, w, v)
    # 자식 노드의 최솟값을 tree에 저장해준다.
    tree[index] = min(tree[index*2], tree[index*2+1])

# 최솟값 찾기
def find_min(start, end, index, left, right):
    # 범위 밖이면 최대값 반환
    if start > right or end < left:
        return [sys.maxsize, sys.maxsize]
    if start >= left and end <= right:
        return tree[index]
    mid = (start+end)//2
    return min(find_min(start, mid, index*2, left, right), find_min(min+1, end, index*2+1, left, right))

n = int(input())
arr_0 = list(map(int, input().split()))
arr = []
for i in range(n):
    # [value, index]
    arr.append([arr_0[i], i+1])
tree = [0] * (4*n) # 넉넉하게 4*n 선언
init(0, n-1, 1)
print(tree)

m = int(input())
for j in range(m):
    tmp = list(map(int, input().split()))
    if tmp[0] == 2:
        print(find_min(0, n-1, 1, 0, n-1)[1])
    elif tmp[0] == 1:
        arr[tmp[1]-1][0] = tmp[2]
        update(0, n-1, 1, tmp[1]-1, arr[tmp[1]-1])