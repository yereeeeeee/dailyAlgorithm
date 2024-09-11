import sys
input = sys.stdin.readline
from collections import deque, defaultdict

n = int(input())
users = defaultdict(list)
for _ in range(n):
    age, name = map(str, input().split())
    age = int(age)
    users[age].append(name)
for a in sorted(users.keys()):
    for b in users[a]:
        print(a, b)
