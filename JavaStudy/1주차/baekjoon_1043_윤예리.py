import sys
input = sys.stdin.readline()

n, m = map(int, input().split())
true_people = list(map(int, input().split()))
dp = [False] * 51
true_num = true_people[0]
if true_num == 0: exit(print(m))

for i in range(1, true_num + 1):
    dp[true_people[i]] = True

true_people = true_people[1:]
parties = [list(map(int, input().split()))[1:] for _ in range(m)]
# print(parties)
answer = 0
for party in parties:
    flag = False
    for person in party:
        if dp[person]: 
            flag = True
            break
    
    if flag:
        for person in party:
            dp[person] = True

for party in parties:
    flag = False
    for person in party:
        if dp[person]: 
            flag = True
            break
    
    # print(party)
    if not flag:
        answer += 1

# print(dp)
print(answer)
