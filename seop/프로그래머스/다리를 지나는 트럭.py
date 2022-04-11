# 스택/큐
# https://programmers.co.kr/learn/courses/30/lessons/42583
# 다리를 지나는 트럭


from collections import deque

def solution(bridge_length, weight, truck_weights):
    
    # 다리 길이만큼 0으로 초기화
    bridge = deque(0 for truck in range(bridge_length))
    # 대기 트럭
    wait = deque(truck_weights)
    
    # 현재 다리 위 트럭들의 무게를 저장할 변수
    m = 0
    # 지난 시간
    i = 0
    
    while True:
        # 다리를 통과할 녀석이 0이 아니면 트럭이니까
        # 다리 위에 있는 트럭들의 무게(m)에서 빼줘야함
        if bridge[0] != 0:
            m -= bridge.popleft()
        else:
            bridge.popleft()
        
        # 대기 트럭이 존재할 경우
        if len(wait) > 0:
            # (현재 다리 위 트럭 무게 + 다음에 들어갈 트럭무게) <= weight
            if m + wait[0] <= weight:
                w = wait.popleft()
                bridge.append(w)
                m += w
            # 무게 제한 때문에 트럭이 다리에 못올라갈 경우. 걍 0넣어줌
            else:
                bridge.append(0)
        # 대기 트럭이 없으면 걍 0넣어줌
        else:
            bridge.append(0) 
        
        # 시간++
        i += 1
        
        # 대기트럭이 없고 다리위에 트럭도 없으면(무게가 0이면 트럭이 없는거겠죠?)
        if len(wait) <= 0 and m <= 0:
            #걸린 시간 리턴
            return i

# 처음에 sum()으로 다리위에 트럭들 무게 합 구하려했는데 시간초과남..
# 그래서 그냥 무게를 저장하는 변수 만들었음..