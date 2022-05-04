# # BFS
# # 벽 부수고 이동하기
# from collections import deque

# N, M = map(int, input().split())

# graph = []
# for i in range(N):
#     graph.append(list(map(int, input())))


# def bfs(graph):

#     visited = [[0]*M for _ in range(N+1)]
#     visited[0][0] = 1

#     queue = deque()
#     queue.append((0,0))

#     while queue:
#         x, y = queue.popleft()
        
#         dx = [-1,1,0,0] # 방향
#         dy = [0,0,-1,1]

#         for i in range(4): # 다음 노드 탐색
#             nx = x + dx[i]
#             ny = y + dy[i]

#             if nx < 0 or nx >= N or ny < 0 or ny >= M: #범위를 벗어날 경우 무시
#                 continue

#             if graph[nx][ny] == 1: # 벽이면 무시
#                 continue

#             if graph[nx][ny] == 0 and visited[nx][ny] == 0: # 다음 노드가 방문하지 않은 노드라면
#                 visited[nx][ny] = visited[x][y] + 1 # 방문처리(현재 노드 값 + 1)
#                 queue.append((nx,ny)) # 큐에 넣어줌
            

#     return visited[N-1][M-1] # 그래프 마지막 값 리턴


# # 1이 있는곳의 위치를 전부다 받아옴
# wall = deque()
# for i in range(N):
#     for j in range(M):
#         if graph[i][j] == 1:
#             wall.append((i,j))

# l = []

# if len(wall) == 0: # 벽이 하나도 없는 경우
#     print(bfs(graph)+1)
# else:
#     while wall:
#         w = wall.popleft()
        
#         graph[w[0]][w[1]] = 0 # 벽 허물어줌
#         l.append(bfs(graph))
#         graph[w[0]][w[1]] = 1 # 벽  세워줌

# answer = []
# for i in l:
#     if i != 0:
#         answer.append(i+1)

# if len(answer) == 0:
#     print(-1)
# else:
#     print(min(answer)-1)