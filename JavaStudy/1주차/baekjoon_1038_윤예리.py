n = int(input())
if n < 10: exit(print(n))
cnt = 9
visited = [False] * 10

def check(length, target_len, value, i):
    global cnt

    if length == target_len: 
        cnt += 1
        # print(cnt, " ", value)
        
        if cnt == n:
            exit(print(value))
        return

    for j in range(0, i):
        if not visited[j]:
            visited[j] = True
            check(length+1, target_len, value+str(j), j)
            visited[j] = False

for i in range(2, 11): # 길이
    for j in range(1, 10): # 첫 번째 숫자
        check(1, i, str(j), j)      

print(-1)