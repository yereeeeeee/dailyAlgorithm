def solution(people, limit):
    people.sort()

    left = 0
    right = len(people) - 1
    answer = 0

    while left <= right:
        # 가장 무거운 사람과 가장 가벼운 사람이 같이 탈 수 있는 경우
        if people[left] + people[right] <= limit:
            left += 1

        # 가장 무거운 사람은 항상 현재 보트에 탑승
        right -= 1
        answer += 1

    return answer