# BFS
# 불!

from collections import deque

N, M  = map(int,input().split())

graph = []
for _ in range(N):
    graph.append(list(map(str,input())))



des = set()
queue = deque()
for i in range(N):
    for j in range(M):
        if (graph[i][j] == '.' or graph[i][j] == 'J') and (i == 0 or i == N-1 or j == 0 or j == M-1): #탈출구
            des.add((i,j))
        elif graph[i][j] =='F': # 불 시작위치
            queue.append((i,j,1))

for i in range(N):
    for j in range(M):
        if graph[i][j] == 'J': # 지훈이 시작위치
            queue.append((i,j,1))


def bfs(graph):
    
    while queue:
        x,y,s = queue.popleft()
        
        if graph[x][y] == 'J' and (x,y) in des: #현재 노드가 탈출구라면
                return s #걸린시간 리턴

        dx = [-1,1,0,0]
        dy = [0,0,-1,1]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]


            if nx < 0 or nx >= N or ny < 0 or ny >= M: #범위를 벗어날 경우 무시
                continue
            
            if graph[nx][ny] == '#': #벽인 경우 무시
                continue

            if graph[nx][ny] == '.': # 방문하지 않았다면
                graph[nx][ny] = graph[x][y]
                queue.append((nx,ny,s+1))

answer = bfs(graph)
if not answer:
    print('IMPOSSIBLE')
else:
    print(answer)
