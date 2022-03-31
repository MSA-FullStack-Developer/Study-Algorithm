from collections import deque


def solution(begin, target, words):
    answer = 0
    # 타겟이 words안에 없는 경우 절대 만들 수 없음
    if target not in words:
        return 0
    queue = deque()
    queue.append([begin, 0])
    visited = [0 for i in range(len(words))]
    while queue:
        word, cnt = queue.popleft()
        if word == target:
            answer = cnt
            break
        for i in range(len(words)):
            temp_count = 0
            if not visited[i]:
                for j in range(len(word)):
                    if word[j] != words[i][j]:
                        temp_count += 1
                # 한글자만 다를때
                if temp_count == 1:
                    queue.append([words[i], cnt+1])
                    visited[i] = 1
    return answer
