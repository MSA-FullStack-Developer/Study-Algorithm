# bfs
# 경쟁적 전염
from collections import deque

N, K = map(int,input().split())

graph = []
for _ in range(N):
    graph.append(list(map(int,input().split())))

S, X, Y = map(int, input().split()) # S초뒤 X,Y에 있는 바이러스 종류

visited = [[0]*N for _ in range(N)]


queue = deque()
list = []
for i in range(N):
    for j in range(N):
        if graph[i][j] != 0 and visited[i][j] == 0: # 0이아니고 방문하지 않았을 경우
            list.append((i,j,0)) #큐에 넣어줌

#정렬해서 큐에 넣어줘야함.
list = sorted(list, key=lambda x: graph[x[0]][x[1]])
queue.extend(list)


def bfs(graph):

    while queue:

        x,y,s = queue.popleft()
        
        if s == S:
            break;

        dx = [-1,1,0,0]
        dy = [0,0,-1,1]

        for i in range(4): #다음 노드 탐색
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= N or ny < 0 or ny >= N: # 범위를 벗어날 경우 무시
                continue
            
            if  graph[nx][ny] == 0: # 다음 노드가 방문하지 않았다면
                graph[nx][ny] = graph[x][y] # 전염시킴
                queue.append((nx,ny,s+1)) # 큐에 넣어줌

bfs(graph)


print(graph[X-1][Y-1])