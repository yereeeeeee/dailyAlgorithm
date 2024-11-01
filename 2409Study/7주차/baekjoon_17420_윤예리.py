import sys
input = sys.stdin.readline

n = int(input())
gifcons = []

# (0, 10): 0번 기프티콘은 10일 남음
day_left = list(enumerate(map(int, input().split())))
# (0, 10): 0번 기프티콘은 10일 째에 사용
use_day = list(enumerate(map(int, input().split())))

print(day_left, use_day)