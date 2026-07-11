def solution(s):
    answer = ''
    tmp = ''

    for char in s:
        if char == ' ':
            answer += tmp.capitalize() + ' '
            tmp = ''
        else:
            tmp += char

    answer += tmp.capitalize()

    return answer