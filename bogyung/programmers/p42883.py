# 큰 수 만들기
# https://programmers.co.kr/learn/courses/30/lessons/42883
def solution(number, k):
    stack=[]
    for i in number:
        while stack and i>stack[-1]: # 스택이 존재할 때, 마지막 값보다 i가 크면
            if k>0:
                stack.pop()
                k-=1
            else:
                break
        stack.append(i)
    # if k>0:  # numbers를 다 순회하고나서 삭제해야할 개수가 더 남아있으면 마지막 부분에서 pop
    #     for i in range(k):
    #         stack.pop()
    if k != 0:
        stack = stack[:-k]

    answer=''.join(stack)

    return answer
print(solution("1924",2))
print(solution("1231234",3))
print(solution("4177252841",4))