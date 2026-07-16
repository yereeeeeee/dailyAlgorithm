def solution(brown, yellow):
    div = []

    def find_divisors(n):
        for i in range(1, int(n ** 0.5) + 1):
            if n % i == 0:
                div.append(i)

    find_divisors(yellow)

    i = 0

    while i < len(div):
        y = div[i]
        x = yellow // y

        if x * 2 + y * 2 == brown - 4:
            return [x + 2, y + 2]

        i += 1