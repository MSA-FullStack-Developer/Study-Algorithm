from re import T
import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())

mx = [-1, 1, 0, 0]
my = [0, 0, -1, 1]

graph = []

visited = [[False] * (M) for _ in range(N)]

for i in range(N):
    graph.append(list(map(int, input().split())))

# 현재 얼음 덩어리가 몇개인지 리턴


def countIce(graph, visit):
    q = deque()
    count = 0
    visit = [[False] * (M) for _ in range(N)]
    for i in range(N):
        for j in range(M):
            if graph[i][j] != 0 and not visit[i][j]:
                count += 1
                q.append((i, j))
                visit[i][j] = True
                while q:
                    x, y = q.popleft()
                    for i in range(4):
                        nx = x + mx[i]
                        ny = y + my[i]
                        if 0 <= nx < N and 0 <= ny < M and not visit[nx][ny]:
                            if graph[nx][ny] == 0:
                                if graph[x][y] > 0:
                                    graph[x][y] -= 1
                                if graph[x][y] == 0:
                                    visit[x][y] = False
                            else:
                                visit[nx][ny] = True
                                q.append((nx, ny))
    return count


ccc = 0
while True:
    c = countIce(graph, visited)
    visited = [[False] * (M) for _ in range(N)]
    if c >= 2:
        print(ccc)
        break
    if c == 0:
        print(0)
        break
    ccc += 1
    # for i in range(N):
    #     for j in range(M):
    #         if graph[i][j] != 0 and not visited[i][j]:
    #             visited[i][j] = True
    #             for i in range(4):
    #                 nx = i + mx[i]
    #                 ny = j + my[i]
    #                 if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 0 and not visited[nx][ny]:
    #                     if graph[i][j] > 0:
    #                         graph[i][j] -= 1
    #                     else:
    #                         break
