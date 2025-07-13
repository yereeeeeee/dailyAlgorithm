import sys

input = sys.stdin.readline
from math import *

n, q = map(int, input().split())
nums = [0] + list(map(int, input().split()))

tree = [0] * 2**(ceil(log(n, 2) + 1))

# 세그먼트 트리 생성
def segment(left, right, i=1):
    # 더 이상 쪼갤 수 없을 때 (leaf 노드에 도달 했을 때)
    if left == right:
        tree[i] = nums[left]
        return tree[i]
    mid = (left+right) // 2
    # 왼쪽 구간합 + 오른쪽 구간합 (top down)
    tree[i] = segment(left, mid, i*2) + segment(mid+1, right, i*2+1)
    return tree[i]

# 구간합 탐색 (조회)
def search(node_left, node_right, query_left, query_right, i=1):
    # node: 트리의 노드
    # query: 사용자가 찾고자 하는 범위

    # 범위를 벗어나면
    if node_right < query_left or query_right < node_left:
        return 0

    # 범위 안에 들어오면
    if query_left <= node_left and node_right <= query_right:
        return tree[i]

    # 둘 다 아니면
    mid = (node_left + node_right) // 2
    return search(node_left, mid, query_left, query_right, i*2) + search(mid+1, node_right, query_left, query_right, i*2+1)

def update(start, end, idx, diff, i=1):
    # idx: 바꾸고 싶은 배열의 인덱스
    # idx가 포함된 구간만 업데이트

    # 구간 안으로 들어오면 끝
    if start > idx or idx > end:
        return

    tree[i] += diff
    if start != end:
        mid = (start + end) // 2
        update(start, mid, idx, diff, i*2)
        update(mid+1, end, idx, diff, i*2+1)

segment(1, n)
for _ in range(q):
    # x ~ y 합, a 번째 수를 b로 바꾸기
    x, y, a, b = map(int, input().split())
    if x > y:
        x, y = y, x

    print(search(1, n, x, y))
    diff = b - nums[a]
    nums[a] = b
    update(1, n, a, diff)


