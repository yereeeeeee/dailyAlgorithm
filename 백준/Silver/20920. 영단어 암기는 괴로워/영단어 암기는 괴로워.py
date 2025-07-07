import sys
input = sys.stdin.readline

n, m = map(int, input().split())

word_list = dict()
for _ in range(n):
    word = input().strip()
    if word in word_list:
        word_list[word] += 1
    else:
        word_list[word] = 1

answers = []
for word in word_list.keys():
    answers.append((-word_list[word], -len(word), word))

answers.sort()
for word in answers:
    if word[1] * -1 >= m:
        print(word[2])
        