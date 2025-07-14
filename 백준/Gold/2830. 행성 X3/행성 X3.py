import sys
input = sys.stdin.readline

population = int(input())  # 사람 수 입력받기
counting_one = [0] * 20  # 각 비트 위치에 1이 몇 번 나왔는지 저장할 배열

for _ in range(population):  # 인원 수만큼 반복
    name = int(input())  # 이름(정수) 입력
    for j in range(20):  # 각 비트 자리 확인
        if (name & (1 << j)) > 0:  # j번째 비트가 1인지 확인
            counting_one[j] += 1  # 해당 비트 위치에 1이 하나 더 있음

intimacy = 0  # 최종 친밀도 합 저장할 변수
for i in range(20):  # 각 비트 위치에 대해
    counting_zero = population - counting_one[i]  # 그 위치에서 0인 사람 수
    intimacy += (1 << i) * counting_zero * counting_one[i]  # XOR가 1이 되는 쌍의 수 * 해당 비트값

print(intimacy)
