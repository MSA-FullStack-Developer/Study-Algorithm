import sys

input = sys.stdin.readline

N, M = map(int, input().split())

INF = float('inf')
graph = [[INF] * (N+1) for _ in range(N+1)]

visited = [[False] * (N+1) for _ in range(N+1)]

for i in range(1, N+1):
    graph[i][i] = 0

for i in range(M):
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = -1
    visited[a][b] = True
    visited[b][a] = True

for k in range(1, N+1):
    for i in range(1, N+1):
        for j in range(1, N+1):
            if graph[i][k] == graph[k][j] and visited[i][k] and visited[k][j]:
                if graph[i][k] == 1:
                    graph[i][j] = 1
                    visited[i][j] = True
                else:
                    graph[i][j] = -1
                    visited[i][j] = True
answer = 0

for i in range(1, N+1):
    graph[i][0] = 0
    if INF not in graph[i]:
        answer += 1

print(answer)
