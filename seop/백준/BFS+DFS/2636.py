# BFS
# 치즈
from collections import deque
N, M = map(int,input().split())

graph = []
for _ in range(N):
    graph.append(list(map(int,input().split())))

def bfs(graph, i,j):
    
    visited = [[0]*M for _ in range(N)]
    queue = deque()
    queue.append((i,j))

    while queue:
        x,y = queue.popleft()

        dx = [-1,1,0,0]
        dy = [0,0,-1,1]

        for i in range(4): # 다음 노드 탐색
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= N or ny < 0 or ny >= M: #범위를 벗어날 경우 무시
                continue 
            
            if graph[x][y] == 0 and visited[nx][ny] == 0: # 다음 노드가 방문하지 않았다면
                visited[nx][ny] = 1 # 방문처리

                if graph[nx][ny] == 1: # 다음노드가 1이라면
                    graph[nx][ny] = 0 # 다음노드를 0으로 바꿔줌 (바꿔주고 끝냄)
                elif graph[nx][ny] == 0: # 다음노드가 0이라면
                    queue.append((nx,ny)) # 큐에 넣어줌
            


def sumGraph(graph):
    a = 0
    for g in graph:
        a += sum(g)
    return a

li = []

while True:   
    
    if sumGraph(graph) != 0:
        li.append(sumGraph(graph))
        bfs(graph,0,0)

        if sumGraph(graph) == 0:
            break

print(len(li))
print(li[-1])
