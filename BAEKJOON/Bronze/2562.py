ls = []
for i in range(9):
    a = int(input())
    ls.append(a)
print(max(ls))
print(ls.index(max(ls))+1)