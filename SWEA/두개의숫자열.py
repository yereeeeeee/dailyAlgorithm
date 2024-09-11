n = list(map(int, input().split()))
m = list(map(int, input().split()))

a=0
b=0

# a가 작은 수, b가 큰 수
if len(n) > len(m): 
    a=m
    b=n
else: 
    a=n
    b=m

sum = 0
for i in range(a):
    for j in range(b):
        sum += int(a[i])*int(b[i])
print(sum)
print('---')