# 큐

from collections import deque

K = int(input())

for _ in range(K):
    N, M  = map(int, input().split())
    data = list(map(int, input().split()))

    queue = deque(data)
    count = 0
    idx = M # 뽑아야할 문서의 인덱스
    
    while True:
        if queue[0] < max(queue) : # 맨 앞의 우선순위가 더 높은 문서가 존재하는경우
            queue.append(queue.popleft())
            idx -= 1 # 뽑아야할 문서의 인덱스
            if idx < 0: # 인덱스가 맨앞번호였으면 맨뒤로 가야함
                idx = len(queue)-1
        else: # 맨 앞의 우선순위가 제일 높다면
            queue.popleft() # 문서를 뽑고
            count += 1  # 카운트 +1
            idx -= 1
            if idx < 0: # 방금 뽑은게 뽑아야할 문서라면 
                print(count)
                break;