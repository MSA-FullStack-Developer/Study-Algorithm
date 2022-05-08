# BFS
# 빙산
from collections import deque

N, M = map(int, input().split())

graph = []
for _ in range(N):
    graph.append(list(map(int,input().split())))



def bfs(graph, start):
    
    queue = deque()
    queue.append(start)
    visited = [[0]*M for _ in range(N)]

    while queue:
        x, y = queue.popleft()
        visited[x][y] = 1
        dx = [-1,1,0,0]
        dy = [0,0,-1,1]

        for i in range(4): # 상하좌우 노드 탐색
            nx = x + dx[i]
            ny = y + dy[i]
            
            
            if visited[nx][ny] == 0 and graph[nx][ny] == 0: # 다음 노드가 방문하지 않았고, 바다라면
                if graph[x][y] > 0:
                    graph[x][y] -= 1 # 빙산만 녹여줌
                continue

            if visited[nx][ny] == 0 and graph[nx][ny] > 0: # 다음 노드가 방문하지 않았고, 빙산이라면
                visited[nx][ny] = 1 # 방문처리 후
                queue.append((nx,ny)) # 큐에 넣어줌


def dfs(graph, visited, start):
    
    stack = []
    stack.append(start)

    while stack:
        x, y = stack.pop()
        visited[x][y] = 1

        dx = [-1,1,0,0]
        dy = [0,0,-1,1]

        for i in range(4): # 상하좌우 노드 탐색
            nx = x + dx[i]
            ny = y + dy[i]
            

            if visited[nx][ny] == 0 and  graph[nx][ny] > 0: #다음 노드가 빙산이고, 방문하지 않은 노드라면
                visited[nx][ny] = 1  # 방문처리 후
                stack.append((nx,ny)) # 스택에 넣어줌

answer = 0 #빙산을 녹인 횟수
melt = False # 빙산이 두덩어리 인지 여부
def solution(answer, melt):
    answer = answer
    melt = melt
    for i in range(1,N-1):
        for j in range(1,M-1):
            if graph[i][j] != 0: # 빙산이라면 

                bfs(graph,(i,j)) #빙산 녹이기
                answer += 1

                # 빙산이 두개이상으로 나눠졌나 검사
                cnt = 0 #빙산 덩어리 수
                visited = [[0]*M for _ in range(N)]
                for a in range(1,N-1):
                    for b in range(1,M-1):
                        if graph[a][b] != 0 and visited[a][b] == 0: # 빙산이고, 방문하지 않았다면
                            dfs(graph, visited, (a,b)) # 빙산 덩어리
                            cnt += 1 # 빙산 덩어리 탐색했으니까 1 더해줌
                            if cnt >= 2: #빙산 덩어리가 2개 이상이라면
                                melt = True

                if melt == True:
                    return answer
    if melt == False:
        return 0

print(solution(answer,melt))
