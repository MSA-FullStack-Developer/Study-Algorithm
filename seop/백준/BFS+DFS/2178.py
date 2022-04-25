# BFS
# 미로 탐색
from collections import deque

# 정수 입력
n, m = map(int, input().split())

# 2차원 리스트 입력
graph = []
for i in range(n):
    graph.append(list(map(int, input()))) 


def bfs(x,y):
    queue = deque([])
    queue.append((x,y))
    
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    
    while queue:
        v = queue.popleft()
        
        for i in range(4): #다음 노드 탐색
            nx = v[0] + dx[i]
            ny = v[1] + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= m: # 범위를 벗어날 경우 무시
                continue
            
            if graph[nx][ny] == 1: #다음 노드가 방문하지 않은 노드라면
                graph[nx][ny] = graph[v[0]][v[1]] + 1 #방문처리하고 (+1 해줘야 여기까지 얼마나 걸리나 알 수 있음)
                queue.append((nx,ny)) # 큐에 넣음



bfs(0,0)
graph[0][0] = 1 # bfs돌리면 2로바뀌니까 1로 해주는데 안해줘도 상관 무..
print(graph[n-1][m-1])