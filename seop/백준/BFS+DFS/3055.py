# BFS
# 탈출
from collections import deque

N, M = map(int,input().split())

graph = []
for _ in range(N):
    graph.append(list(map(str,input())))

des = []
queue = deque()
for i in range(N):
    for j in range(M):
        if graph[i][j] == '*':
            queue.append((i,j))
for i in range(N):
    for j in range(M):
        if graph[i][j] =='S':
            queue.append((i,j))
            graph[i][j] = 0 #시작노드를 0으로 해줌
        if graph[i][j] == 'D':
            des.append((i,j))

def bfs(graph):

    while queue:
        x,y = queue.popleft()
        
        dx = [0,0,-1,1]
        dy = [-1,1,0,0]

        for i in range(4): # 상하좌우 탐색
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= N or ny < 0 or ny >= M: # 범위를 벗어난 경우 무시
                continue

            if str(graph[x][y]).isdigit() and graph[nx][ny] == 'D':
                return graph[x][y]+1

            if graph[nx][ny] == '.': # 다음 노드가 방문하지 않은 노드라면
                if graph[x][y] == '*': # 현재 노드가 물이라면
                    graph[nx][ny] = graph[x][y] #다음 노드는 현재노드와 같게 만들어줌
                    queue.append((nx,ny))
                elif str(graph[x][y]).isdigit() == True: # 현재 노드가 숫자(고슴도치)라면
                    graph[nx][ny] = graph[x][y] + 1 # 다음노드 = 현재노드 +1
                    queue.append((nx,ny))
answer = 'KAKTUS'
answer = bfs(graph)
if answer:
    print(answer)
else:
    print('KAKTUS')