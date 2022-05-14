import sys
from collections import deque

input = sys.stdin.readline

M, N = map(int, input().split())
maze = []
for i in range(N):
    maze.append(list(map(int, list(input().rstrip()))))

# 상 하 좌 우
mx = [-1, 1, 0, 0]
my = [0, 0, -1, 1]

q = deque()
q.append((0, 0))
INF = float('inf')
# 가로 : M, 세로 : N
dist = [[INF] * (M) for _ in range(N)]
dist[0][0] = 0
while q:
    x, y = q.popleft()
    for i in range(4):
        nx = x+mx[i]
        ny = y+my[i]
        if 0 <= nx < N and 0 <= ny < M:
            if dist[nx][ny] == INF:
                if maze[nx][ny] == 0:
                    dist[nx][ny] = dist[x][y]
                    q.appendleft((nx, ny))
                else:
                    dist[nx][ny] = dist[x][y] + 1
                    q.append((nx, ny))

print(dist[N-1][M-1])
