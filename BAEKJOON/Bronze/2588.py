a = int(input())
b = input()
c = list(b)

for i in range(3):
    print(a * int(c.pop()))

print(a*int(b))