import sys
sys.setrecursionlimit(1000000)
input = sys.stdin.readline

n, m, k = map(int, input().split())
board = [list(input().strip()) for _ in range(n)]
words = [input().strip() for _ in range(k)]

dx = [-1, 0, 1, 0, -1, 1, 1, -1]
dy = [0, 1, 0, -1, 1, 1, -1, -1]

# 메모이제이션: (x, y, depth, word_index)
memo = {}

def dfs(x, y, depth, word, word_len):
    if depth == word_len:
        return 1

    key = (x, y, depth)
    if key in memo and word in memo[key]:
        return memo[key][word]

    cnt = 0
    for d in range(8):
        nx = (x + dx[d]) % n
        ny = (y + dy[d]) % m
        if board[nx][ny] == word[depth]:
            cnt += dfs(nx, ny, depth + 1, word, word_len)

    if key not in memo:
        memo[key] = {}
    memo[key][word] = cnt
    return cnt

# 결과 저장
result = {}
for word in words:
    if word in result:
        print(result[word])
        continue

    total = 0
    for i in range(n):
        for j in range(m):
            if board[i][j] == word[0]:
                total += dfs(i, j, 1, word, len(word))

    result[word] = total
    print(total)
