arr = []
for i in range(30):
    arr.append(i+1)
    
for j in range(28):
    hw = int(input())

    arr.pop(arr.index(hw))
print(arr[0])
print(arr[1])