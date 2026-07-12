def solution(s):
    answer = [0, 0]
    
    tmp = 0
    while True:
        
        if s == '1':
            break
        else:
            answer[1] += s.count('0')
            answer[0] += 1
            tmp = s.count('1')
            s = str(bin(tmp)[2:])
            
    
    return answer