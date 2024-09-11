a = int(input())
b = int(input())
c = int(input())
result = str(a*b*c)
print(result.count('0'))
for j in range(1, 10):
    j = str(j)
    print(result.count(j))