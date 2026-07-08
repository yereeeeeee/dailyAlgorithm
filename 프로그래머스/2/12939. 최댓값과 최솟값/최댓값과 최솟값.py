def solution(s):
    answer = ''
    ls = list(map(int, s.split()))
    answer = str(min(ls)) + " " + str(max(ls))
    return answer