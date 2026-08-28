from itertools import combinations

def solution(n, q, ans):
    answer = 0
    m = len(ans)
    ls = [i for i in range(1, n+1)]
    
    # 하나도 없는 케이스
    for i in range(m):
        if ans[i] == 0:
            for j in q[i]:
                try: ls.remove(j)
                except: pass
    
    # 조합 만들기
    for comb in combinations(ls, 5):
        for i in range(m):
            cnt = 0
            for k in q[i]:
                if k in comb:
                    cnt += 1
            if cnt != ans[i]:
                break
        else:
            answer += 1    
            
    return answer