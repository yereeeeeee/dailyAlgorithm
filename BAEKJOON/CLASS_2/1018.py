w = ['WBWBWBWB','BWBWBWBW','WBWBWBWB','BWBWBWBW','WBWBWBWB','BWBWBWBW','WBWBWBWB','BWBWBWBW']
b = ['BWBWBWBW','WBWBWBWB','BWBWBWBW','WBWBWBWB','BWBWBWBW','WBWBWBWB','BWBWBWBW','WBWBWBWB']

def check_board():
    pass

n, m = map(int, input().split())
arr = []
for _ in range(n):
    ls = list(input())
    arr.append(ls)
print(arr)

for i in range(n):
    for j in range(m):
        check_board()
