def solution(number, k):
    stack = []

    for i in number:
        while stack and i > stack[-1]:
            if k > 0:
                stack.pop()
                k -= 1
            else:
                break
        stack.append(i)

    # k를 다 사용했는데 남은 경우
    if k > 0:
        for i in range(k):
            stack.pop()
    answer = "".join(stack)
    return answer
