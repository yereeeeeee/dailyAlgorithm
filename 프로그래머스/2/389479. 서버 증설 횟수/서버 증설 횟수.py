def solution(players, m, k):
    answer = 0
    return_list = [0] * 24
    n = 0

    for i in range(24):
        player = players[i]

        # 만료된 서버 반납
        n -= return_list[i]

        if player < n * m:
            continue
        else:
            add = 0
            while player >= (n + 1) * m:
                n += 1
                add += 1

            if i + k < 24:
                return_list[i + k] += add

            answer += add

    return answer