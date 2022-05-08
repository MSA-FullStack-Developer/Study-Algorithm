# BFS
# 말이 되고픈 원숭이

from collections import deque

K = int(input())
M, N = map(int,input().split())

graph = []
for _ in range(N):
    graph.append(list(map(int,input().split())))

# 그냥 이동할 때 다음 노드
dx = [-1,1,0,0,2,1,-1,-2,-2,-1,1,-1]
dy = [0,0,-1,1,1,2,2,1,-1,-2,-2,2]

visited = [[[0,K]]*M for _ in range(N)]
for g in graph:
    print(g)
print('-------')
for v in visited:
    print(v)

def bfs(graph,x,y,k):
    visited = [[[0,0]]*M for _ in range(N)]
    queue = deque()
    queue.append((x,y,k))

    while queue:

        x,y,k = queue.popleft()
        visited[x][y] = 2

        for i in range(12): #다음 노드 탐색
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx > 0 or nx <= N or ny > 0 or ny <= M: #범위를 벗어날 경우 무시
                continue
