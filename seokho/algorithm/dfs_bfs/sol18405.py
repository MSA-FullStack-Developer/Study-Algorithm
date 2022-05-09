import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int, input().split())

graph = []
visited = [[False] * (N) for _ in range(N)]

for i in range(N):
    graph.append(list(map(int, input().split())))

S, X, Y = map(int, input().split())


q = []
count = 0
for i in range(N):
    for j in range(N):
        if graph[i][j] != 0:
            q.append((graph[i][j], i, j, count))

sorted(q)
q = deque(q)

# 상 하 좌 우
mx = [-1, 1, 0, 0]
my = [0, 0, -1, 1]
while q:
    temp, x, y, c = q.popleft()
    if c == S:
        break
    for i in range(4):
        nx = x + mx[i]
        ny = y + my[i]
        if 0 <= nx < N and 0 <= ny < N:
            if visited[nx][ny] == False and graph[nx][ny] == 0:
                visited[nx][ny] = True
                graph[nx][ny] = temp
                q.append((temp, nx, ny, c+1))

print(graph)
print(graph[X-1][Y-1])
