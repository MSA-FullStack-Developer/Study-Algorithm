from collections import deque


def solution(skill, skill_trees):
    count = 0

    for st in skill_trees:
        stack = deque(list(skill))
        # 스킬에 없는 문자는 패스 만약 스택에 있는 문자인데 맨앞에 위치 한게 아니면 break 맞다면 popleft() 스킬트리를 끝까지 확인했으면 +1 스택에 든게 없다면 +1
        flag = True
        for i in st:
            if stack and i in stack and i == stack[0]:
                stack.popleft()
            elif stack and i in stack and i != stack[0]:
                flag = False
                break

        if flag:
            count += 1
    return count
