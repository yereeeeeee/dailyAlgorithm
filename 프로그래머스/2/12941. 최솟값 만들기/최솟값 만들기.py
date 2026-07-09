import heapq

def solution(A,B):
    answer = 0
    n = len(A)
    
    heapq.heapify(A)
    
    C = []
    for i in B:
        heapq.heappush(C, -i)

    for _ in range(n):
        a = heapq.heappop(A)
        b = -heapq.heappop(C)
        answer += (a*b)

    return answer