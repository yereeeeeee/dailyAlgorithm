def solution(n):
    answer = 0
    
    def calc(i, j):
        return sum(k for k in range(i, j+1))
    
    left = 1
    right = 1
    
    while left <= right:
        k = calc(left, right)
        
        if k < n:
            right += 1
        elif k > n:
            left += 1
        else:
            answer += 1
            print(left, right)
            left += 1
    
    return answer