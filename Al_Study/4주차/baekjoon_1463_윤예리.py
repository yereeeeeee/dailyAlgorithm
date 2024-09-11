x = int(input())
memo = [0] * (x+1)

for i in range(2, x+1):
    memo[i] = memo[i-1] + 1     # 최악의 경우 먼저 넣어주고

    if i % 6 == 0:
        memo[i] = min(memo[i-1], memo[i//3], memo[i//2])+1
    elif i % 3==0:                # 3으로 나눠지면 최소값 비교 + 1
        memo[i] = min(memo[i-1], memo[i//3])+1
    elif i % 2==0:                # 2로도 나눠보고 최소값 비교 + 1
        memo[i] = min(memo[i-1], memo[i//2])+1

print(memo[x])