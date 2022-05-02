# BFS
# 토마토

from collections import deque

M, N = map(int, input().split()) # M = 열, N = 행

graph = []
for _ in range(N):
    graph.append(list(map(int,input().split())))

queue = deque()

for i in range(N):
    for j in range(M):
        if graph[i][j] == 1: # 익은 토마토 큐에 넣어줌.
            queue.append((i,j))

def bfs(queue):

    while queue: #큐가 빌 때 까지 반복
        x,y = queue.popleft()

        dx = [-1,1,0,0] #방향
        dy = [0,0,-1,1]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= N or ny < 0 or ny >= M: #범위를 벗어날 경우 무시
                continue 

            if graph[nx][ny] == 0: #다음 토마토가 익지 않았다면..
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx,ny))

if not queue:
    no = -1
else:
    bfs(queue)

answer = 0
no = 0
for i in range(N):
    for j in range(M):
        if graph[i][j] == 0:
            no = -1
        else:
            answer = max(answer,graph[i][j])
if no == -1:
    print(-1)
else:
    print(answer-1)