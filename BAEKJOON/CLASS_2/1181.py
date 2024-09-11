n = int(input())
ls = set()
for _ in range(n):
    char = input()
    ls.add(char)

result = sorted(ls, key=lambda x:(len(x), x))
print(*result, sep='\n')