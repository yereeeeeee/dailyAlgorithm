N = int(input())
M = list(str(N))
result = 0
for m in M:
    result += int(m)

print(N+result)