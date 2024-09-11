lst = input()
for s in lst:
    if s.isupper():
        print(s.lower(), end='')
    else:
        print(s.upper(), end='')