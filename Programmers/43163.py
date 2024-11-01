from collections import deque

def check(cur, word):
    same_num = 0
    for i in range(m):
        if cur[i] == word[i]:
            same_num += 1
    if same_num == 1:
        return True
    return False


def solution(begin, target, words):
    if target not in words:
        return 0

    n = len(words)
    m = len(begin)

    q = deque([(begin, 0)])
    visited = [0] * (n + 1)

    while q:
        cur, num = q.popleft()

        if cur == target:
            return num

        for i in range(n):
            if not visited[i] and check(cur, words[i]):
                visited[i] = 1
                q.append((words[i], num + 1))
                print(words[i])

    return 0

print(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]))