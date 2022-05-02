# BFS
# 점프 점프
from collections import deque

N = int(input())

graph = list(map(int,input().split()))

queue = deque()
queue.append(0)
visited = [0]*N # 해당 위치까지 얼마나 걸리는지 저장할 리스트

while queue:
    v = queue.popleft() # 인덱스 번호임

    for i in range(graph[v]+1): #현재 인덱스 부터 인덱스 값에 해당하는 거리까지 반복
        if v+i >= N: # 범위를 벗어난다면 무시
            continue

        if visited[v+i] == 0: # 다음 노드가 방문하지 않았따면
            visited[v+i] = visited[v] + 1 # 방문처리 후
            queue.append(v+i) # # 큐에 넣어줌

if visited[-1] == 0:
    print(-1)
else:
    print(visited[-1]-1)