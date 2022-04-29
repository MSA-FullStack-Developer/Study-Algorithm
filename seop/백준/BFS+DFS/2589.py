# BFS
# 보물섬

from collections import deque

N, M = map(int, input().split())

graph = []
for _ in range(N):
    graph.append(list(map(str,input())))


def bfs(graph, start):
    queue = deque()
    queue.append(start)
    
    visited = [[0]*M for _ in range(N)] # 시작노드부터 해당노드까지 걸리는 거리를 담은 리스트
    visited[start[0]][start[1]] = 1

    dx = [-1,1,0,0] # 방향
    dy = [0,0,-1,1]
    cnt = 0

    while queue:
        x, y = queue.popleft()

        for i in range(4): # 다음 노드 탐색 (동서남북)
            nx = x + dx[i]
            ny = y + dy[i]

            if nx >= N or nx < 0 or ny >= M or ny < 0: #공간을 벗어날 경우 무시
                continue

            if graph[nx][ny] == 'L' and visited[nx][ny] == 0: # 방문하지 않은 노드라면
                visited[nx][ny] = visited[x][y] + 1 # 노드까지의 거리를 기록해줌(최단거리)
                queue.append((nx,ny)) #큐에 넣어줌
                cnt = max(cnt, visited[nx][ny])
    return cnt-1 # 시작노드가 1부터 시작했으니까 마지막에 1빼줘야 거리나옴

answer = 0
for i in range(N):
    for j in range(M):
        if graph[i][j] == 'L':
            answer = max(answer,bfs(graph, (i,j)))
print(answer)
