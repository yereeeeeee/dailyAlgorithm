n = int(input())
costs = list(map(int, input().split()))

def youngsik(x):
    m = 0
    while x >= 30:
        m += 10
        x -= 30
    if x >= 0:
        m += 10
    return m

def misik(x):
    y = 0
    while x >= 60:
        y += 15
        x -= 60
    if x >= 0:
        y += 15
    return y

yy = 0
mm = 0
for cost in costs:
    yy += youngsik(cost)
    mm += misik(cost)
    # print(youngsik(cost), misik(cost))

if yy < mm:
    print("Y", yy)
elif yy == mm:
    print("Y M", yy)
else:
    print("M", mm)
