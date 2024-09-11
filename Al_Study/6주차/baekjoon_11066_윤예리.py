# 최대한 깊은 depth에서 많이 합쳐놓고 최종 합치기
# 자식 노드가 2개인 노드가 많을 수록 유리

T = int(input())
for tc in range(1, T+1):
    k = int(input())
    arr = sorted(list(map(int, input().split())))
    dp = [0] * k
