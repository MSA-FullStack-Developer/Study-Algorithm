import sys
from collections import deque
from tkinter.tix import Tree

input = sys.stdin.readline
M, N = map(int, input().split())

# 상 하 좌 우
my = [-1, 1, 0, 0]
mx = [0, 0, -1, 1]

graph = []
for _ in range(N):
    graph.append(list(map(int, input().split())))

visited = [[False] * M for _ in range(N)]

start = []
# 시작할 좌표
for i in range(N):
    for j in range(M):
        if graph[i][j] == 1 and not visited[i][j]:
            visited[i][j] = True
            start.append((i, j, 0))

# 갈수없는곳은 이미 방문처리
for i in range(N):
    for j in range(M):
        if graph[i][j] == -1:
            visited[i][j] = True

q = deque(start)
ans = 0
while q:
    y, x, c = q.popleft()
    ans = max(ans, c)
    for i in range(4):
        ny = y + my[i]
        nx = x + mx[i]
        if 0 <= ny < N and 0 <= nx < M:
            if visited[ny][nx] == False and graph[ny][nx] == 0:
                graph[ny][nx] = 1
                visited[ny][nx] = True
                q.append((ny, nx, c+1))

flag = True
for i in range(N):
    for j in range(M):
        # 토마토가 다 익지 못하는 상황 (하나라도 방문하지 못한곳이 있는 경우)
        if visited[i][j] == False:
            print(-1)
            flag = False
            exit()

# 토마토가 시작부터 다 익어있는 경우
if ans == 0:
    print(0)
    flag = False

if flag:
    print(ans)
