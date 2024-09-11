n, m = map(int, input().split())
a = list(map(int, input().split()))
max_value = 0
for i in range(n):
    for j in range(i+1, n):
        for k in range(j+1, n):
            card = 0
            card += a[i] + a[j] + a[k]
            if card > m:
                card = 0
            else:
                if card > max_value:
                    max_value = card

print(max_value)