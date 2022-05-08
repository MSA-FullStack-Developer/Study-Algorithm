# bfs
# 경쟁적 전염

# 1. 바이러스가 있는 위치정보, 시간정보를 전부 큐에 넣어줌  (시간정보 중요)
# 2. BFS 수행 => 
# 3. 큐에서 원소를 하나 꺼낸 다음 상하좌우 노드가 0이라면 다음 노드를 감염시켜줌
# 5. 다음노드를 큐에 넣어줄 땐 시간 정보(s)를 +1 해서넣어줘야함.
# 4. 감염시켜주고 바로 큐에 주가해줌
# 5. (큐에서 원소 꺼낼 때 시간이 목표 시간이면 바로 멈춤)
# 6. 바로 전까지는 다 탐색 했으니까
# 7. 큐는 선입선출이라는 것을 잘 기억해야함...

# 처음에 정렬해서 큐에 넣어줬으니 정렬된 순서대로 계속 큐에 들어감

from collections import deque

N, K = map(int,input().split())

graph = []
for _ in range(N):
    graph.append(list(map(int,input().split())))

S, X, Y = map(int, input().split()) # S초뒤 X,Y에 있는 바이러스 종류


queue = deque()
list = []
for i in range(N):
    for j in range(N):
        if graph[i][j] != 0: # 0이아니고 방문하지 않았을 경우
            list.append((i,j,0)) #큐에 넣어줌

# 처음에 정렬해서 큐에 넣어줘야함.
list = sorted(list, key=lambda x: graph[x[0]][x[1]])
queue.extend(list)


def bfs(graph):

    while queue:

        x,y,s = queue.popleft()
        
        # 시간초가 됐다면 멈춰줌
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
                queue.append((nx,ny,s+1)) # 큐에 넣어줌 (s는 시간정보)

bfs(graph)


print(graph[X-1][Y-1])