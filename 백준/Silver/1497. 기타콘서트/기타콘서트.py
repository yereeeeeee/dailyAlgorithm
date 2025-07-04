import sys
input = sys.stdin.readline
from itertools import combinations

n, m = map(int, input().split())

guitars = {}

for _ in range(n):
    g,k = input().split()
    pos = [0] * m
    for i in range(m):
        if k[i] == "Y":
            pos[i] = 1
    guitars[g] = pos

# 기타 개수 
min_guitars = -1
max_song = 0
for i in range(1, m+1):

    comb = list(combinations(guitars.keys(), i))
    
    for j in comb:
        songs = [0] * m
        for c in j:
            for l in range(m):
                songs[l] = guitars[c][l] | songs[l]
        
        curr_songs = sum(songs)
        if curr_songs == m:
            exit(print(i))
        elif curr_songs > max_song:
            max_song = curr_songs
            min_guitars = i

print(min_guitars)