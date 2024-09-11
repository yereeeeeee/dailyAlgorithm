a, b, v = map(int, input().split())
day = 0

if a >= v:
    print(1)

else:
    day += ((v-a)//(a-b))
    if (v-a) % (a-b) == 0:
        print(day+1)
    else:
        print(day+2)