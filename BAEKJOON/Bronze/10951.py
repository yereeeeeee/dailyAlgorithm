a = 0
b = 0
while 1:
    try:
        a, b = map(int, input().split(' '))
        print(a+b)
    except:
        break

