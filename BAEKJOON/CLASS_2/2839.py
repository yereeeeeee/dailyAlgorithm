n = int(input())

if not n % 5:
    exit(print(n//5))

fives = n//5 + 1
dp = [i for i in range(fives)]
# print(dp)

for i in range(fives):
    j = n - dp[i] * 5

    if not j % 3:
        dp[i] += j//3
    else:
        dp[i] = 0

result = float('inf')
if sum(dp) == 0:
    exit(print(-1))
else:
    for i in dp:
        if i:
            result = min(i, result)

print(result)