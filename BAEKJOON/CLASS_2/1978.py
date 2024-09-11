n = int(input())
ls = list(map(int, input().split()))
count = 0

for i in ls:
    if i == 1:
        count += 1
        continue

    for j in range(2, i):
        if i % j == 0:
            count += 1
            break
    else:
        continue
print(n-count)