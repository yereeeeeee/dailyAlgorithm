import sys
input = sys.stdin.readline

while True:
    n = input().strip()
    if int(n) == 0:
        exit()

    for i in range(len(n)//2):
        # print(i)
        if n[i] != n[-(i+1)]:
            print('no')
            break
    else:
        print('yes')