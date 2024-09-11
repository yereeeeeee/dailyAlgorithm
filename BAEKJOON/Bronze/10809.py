S = list(input())
al = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
arr = []
for a in al:
    if a not in S:
        arr.append(-1)
    else:
        arr.append(S.index(a))
for ar in arr:
    print(ar, end=' ')