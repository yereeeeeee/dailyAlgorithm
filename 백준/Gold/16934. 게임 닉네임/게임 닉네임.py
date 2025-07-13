import sys
input = sys.stdin.readline
from collections import defaultdict

n = int(input().strip())
names = []  # 닉네임 저장 리스트
for _ in range(n):
    word = input().rstrip()  # 개행 제거한 닉네임 입력
    names.append(word)       # 리스트에 저장

# 트라이의 노드 클래스 (글자 하나를 저장함)
class Node(object):
    def __init__(self, key, data=None):
        self.key = key            # 현재 노드의 글자
        self.data = data          # 단어 끝이면 전체 단어 저장
        self.children = {}        # 자식 노드들 (딕셔너리로 연결)

# 트라이 전체 구조를 관리하는 클래스
class Trie(object):
    def __init__(self):
        self.root = Node(None)    # 루트 노드 생성 (아무 글자 없음)

    # 단어 삽입 함수
    def insert(self, string):
        now = self.root           # 루트 노드부터 시작
        for char in string:       # 단어의 각 글자에 대해
            if char not in now.children:
                # 해당 글자가 없으면 새 노드 만들어서 연결
                now.children[char] = Node(char)
            now = now.children[char]  # 다음 노드로 이동
        now.data = string             # 마지막 노드에 단어 저장
        same_nickname[string] += 1    # 같은 단어 등장 횟수 +1

    # 단어 검색 함수 (최소 접두어 or 중복 번호 붙이기)
    def search(self, string):
        now = self.root
        result = ''              # 결과 접두어를 저장할 문자열
        for char in string:
            result += char       # 글자 하나씩 붙임
            if char in now.children:
                now = now.children[char]  # 자식 노드로 이동
            else:
                return result     # 처음 등장하는 지점이면 그 접두어 반환

        # 이미 존재하는 단어면 중복 번호 붙이기
        if now.data != None:
            result += str(same_nickname[string] + 1)

        return result            # 최종 결과 반환

# 트라이 객체 생성
check = Trie()

# 같은 닉네임 횟수를 저장하는 딕셔너리 (기본값 0)
same_nickname = defaultdict(int)

# 닉네임 하나씩 처리
for i in range(n):
    print(check.search(names[i]))  # 먼저 검색해서 결과 출력
    check.insert(names[i])         # 트라이에 등록 (중복 카운팅 포함)
