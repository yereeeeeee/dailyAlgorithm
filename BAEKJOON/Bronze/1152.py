# split()을 사용하면 모든 공백이 없어짐
print(len(input().strip().split()))

# 아래는 틀린 답임
# a = input()
# b= a.strip()
# c = list(map(str, b.split(' ')))
# print(len(c))