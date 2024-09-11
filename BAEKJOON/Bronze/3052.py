arr = []
for i in range(10):
    a = int(input())
    arr.append(a%42)
print(int(len(set(arr))))
