def check(x):
    global cnt
    # tmp = 0
    for y in ls:
        result = [0, 0]
        for z in range(3):
            if str(y[0])[z] == str(x)[z]:
                result[0] += 1      # 스트라이크
            elif str(x)[z] in str(y[0]):
                result[1] += 1      # 볼
        if result[0] == y[1] and result[1] == y[2]:
            continue
        else:
            return
    else:
        cnt += 1

n = int(input())
ls = []
for _ in range(n):
    ls.append(list(map(int, input().split())))

ls.sort(key=lambda x:x[1])
cnt = 0
for i in range(1, 10):
    for j in range(1, 10):
        for k in range(1, 10):
            if i == j or j==k or k==i:
                continue
            a = i*100+j*10+k
            check(a)
print(cnt)