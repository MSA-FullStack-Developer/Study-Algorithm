# bfs
# 경쟁적 전염
from collections import deque

N, K = map(int,input().split())

graph = []
for _ in range(N):
    graph.append(list(map(int,input().split())))

S, X, Y = map(int, input().split()) # S초뒤 X,Y에 있는 바이러스 종류

visited = [[0]*N for _ in range(N)]

def bfs(graph):

    queue = deque()
    for i in range(N):
        for j in range(N):
            if graph[i][j] != 0 and visited[i][j] == 0: # 0이아니고 방문하지 않았을 경우
                queue.append((i,j)) #큐에 넣어줌

    #큐 정렬
    if queue:
        queue = sorted(list(queue), key= lambda x: graph[x[0]][x[1]]) 
        queue = deque(queue)
    
    while queue:

        x,y = queue.popleft()
        visited[x][y] = 1

        dx = [-1,1,0,0]
        dy = [0,0,-1,1]

        for i in range(4): #다음 노드 탐색
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= N or ny < 0 or ny >= N: # 범위를 벗어날 경우 무시
                continue
            
            if visited[nx][ny] == 0 and graph[nx][ny] == 0: # 다음 노드가 방문하지 않았다면
                graph[nx][ny] = graph[x][y] # 전염만 시킴 (방문처리는 아직 X)

A = min(N,S)
for i in range(A):
    bfs(graph)


print(graph[X-1][Y-1])