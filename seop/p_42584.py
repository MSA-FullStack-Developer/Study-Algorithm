# 스택/큐
# https://programmers.co.kr/learn/courses/30/lessons/42584
# 주식가격

from collections import deque

def solution(prices):
    
    answer = [] # 결과담을 배열
    queue = deque(prices) # 큐로만들어줌

    while queue:
        price = queue.popleft() #큐에서 하나 뽑고
        c = 0
        for i, q in enumerate(queue): # 뒤에 주가들을 봄
            if price > q: # 주가가 떨어졌다면
                c = i+1
                break
            else: # 주가가 안떨어졌으면
                c += 1
        answer.append(c)
    
    return answer

# range로하면 시간초과남
# enumerate로 하면 ㄱㅊ