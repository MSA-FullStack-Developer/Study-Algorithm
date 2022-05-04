# BFS
# 아기 상어 2

from collections import deque

N, M = map(int, input().split())

data = []
for i in range(N):
    data.append(list(map(int,input().split())))

def bfs(data, start):
    graph = [d[:] for d in data]

    queue = deque()
    queue.append(start)

    graph[start[0]][start[1]] = 2 # 첫노드 2부터 시작
    while queue:
        x, y = queue.popleft()

        dx = [0,1,1,1,0,-1,-1,-1] # 8가지 방향 정의
        dy = [1,1,0,-1,-1,-1,0,1]

        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= N or ny <0 or ny >=M: #범위를 벗어날 경우 무시
                continue
            if graph[nx][ny] == 1: # 다음 노드가 상어가 있다면

                return graph[x][y]-1 # 2부터 시작했으니까

            if graph[nx][ny] == 0: #다음 노드가 방문하지 않은 노드라면
                graph[nx][ny] = graph[x][y] + 1 # 전 노드 + 1 (방문 처리)
                queue.append((nx,ny)) #방문하지 않았으니 큐에 넣어줌.

                
answer = 0
for i in range(N):
    for j in range(M):
        if data[i][j] == 0:
            answer = max(answer, bfs(data,(i,j)))
print(answer)