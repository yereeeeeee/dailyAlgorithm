def solution(s):
    answer = 0
    n = len(s)

    def calc(st):
        nonlocal answer

        stack = []
        pair = {
            ')': '(',
            ']': '[',
            '}': '{'
        }

        for c in st:
            if c in '([{':
                stack.append(c)
            else:
                # 닫는 괄호인데 열린 괄호가 없는 경우
                if not stack:
                    return

                # 가장 최근에 열린 괄호와 종류가 다른 경우
                if stack[-1] != pair[c]:
                    return

                stack.pop()

        # 열린 괄호가 모두 닫힌 경우
        if not stack:
            answer += 1

    for i in range(n):
        calc(s)
        s = s[1:] + s[0]

    return answer