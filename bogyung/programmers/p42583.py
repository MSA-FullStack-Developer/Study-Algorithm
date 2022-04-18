# 다리를 지나는 트럭
# https://programmers.co.kr/learn/courses/30/lessons/42583
from collections import deque
def solution(bridge_length, weight, truck_weights):
    answer = 0
    bridge=deque([0 for _ in range(bridge_length)])  # 현재 다리 상황, 다리 길이만큼 만든 다음에 어떤 트럭이 있을지 기록
    deq=deque(truck_weights)  # 대기 트럭
    bridge_weight=sum(bridge)

    while bridge:  # 대기 트럭이 다 없어질 때까지
        bridge_weight-=bridge[0]
        bridge.popleft()
        answer+=1
        if deq:
            if bridge_weight + deq[0] <= weight: # sum(다리에 있는 트럭)+현재 트럭<10
                bridge_weight+=deq[0]
                bridge.append(deq.popleft())
            else:  # weight 초과시
                bridge.append(0)

    return answer

print(solution(2, 10, [7,4,5,6]))
print(solution(100, 100, [10]))
print(solution(100,100,[10,10,10,10,10,10,10,10,10,10]))