# BFS
# 적록색약
from collections import deque

def bfs(x,y,graph):
    
    queue = deque([])
    queue.append((x,y))

    dx = [-1,1,0,0] # 방향
    dy = [0,0,-1,1]
    
    while queue:
        v = queue.popleft()

        for i in range(4):
            nx = v[0] + dx[i]
            ny = v[1] + dy[i]

            if nx < 0 or nx >= N or ny < 0 or ny >= N: # 범위를 벗어날 경우 무시
                continue
            if graph[nx][ny] == graph[v[0]][v[1]] and visited[nx][ny] == 0: # 다음 노드와 값이 같으면
                visited[nx][ny] = 1 # 방문처리
                queue.append((nx, ny))

N = int(input())
graph = []
for _ in range(N):
    graph.append(list(map(str,input())))

#일반인이 보는 구역
visited = [[0]*N for _ in range(N)]
cnt1 = 0
for i in range(N):
    for j in range(N):
        if visited[i][j] == 0: # 방문하지 않은 노드라면 bfs 수행
            cnt1+=1
            bfs(i,j,graph)

#적록색약이 보는 구역
cnt2 = 0
visited = [[0]*N for _ in range(N)]
for i in range(N): # 'G'를 'R'로 바꿔줌
    for j in range(N):
        if graph[i][j] == 'G':
            graph[i][j] = 'R'

for i in range(N):
    for j in range(N):
        if visited[i][j] == 0:
            cnt2+=1
            bfs(i,j,graph)
print(cnt1, cnt2)