# 큐
# 요세푸스 문제 0
from collections import deque

N, K = map(int,input().split())

queue = deque([i for i in range(1,N+1)])
data = []

while queue: # 큐가 빌 때 까지 반복
    for i in range(K-1):
        queue.append(queue.popleft())
    data.append(queue.popleft())

print("<" + ', '.join(map(str,data)) + ">")