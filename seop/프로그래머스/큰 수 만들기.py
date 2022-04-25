# 탐욕법(Greedy)
# https://programmers.co.kr/learn/courses/30/lessons/42883
# 큰 수 만들기

def solution(number, k):
    answer = ''
    stack = [number[0]]
    
    for num in number[1:]:
        
        if stack[-1] >= num: # 스택 마지막보다 num이 작거나 같으면
            stack.append(num) # 일단 그냥 추가

        elif stack[-1] < num: # 스택 마지막보다 num이 크면
            while len(stack) > 0:
                if stack[-1] < num and k>0: #스택 마지막이 num보다 작으면 pop (num보다 큰애가 나올때까지 반복할거임)
                    k-=1
                    stack.pop()
                else: # 스택 마지막이 num보다 큰 경우 또는 k가 0보다 작은경우
                    break;
                    
            stack.append(num)
    
    # k가 남는경우(제거할게 남았으면) 뒤에서부터 지워줌
    if k > 0:
        stack = stack[:-k]
    return ''.join(stack)