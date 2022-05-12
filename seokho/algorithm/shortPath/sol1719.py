import sys

input = sys.stdin.readline
n, m =map(int, input().split())

INF = float('inf')

graph = [[INF] * (n+1) for _ in range(n+1)]
anGraph = [[0] * (n+1) for i in range(n+1)]

for i in range(1, n+1):
    graph[i][i] = 0
    anGraph[i][i] = "-"

for i in range(m):
    a, b, c = map(int, input().split())
    graph[a][b] = c
    graph[b][a] = c
    anGraph[a][b] = b
    anGraph[b][a] = a

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            if graph[i][j] > graph[i][k] + graph[k][j]:
                graph[i][j] = graph[i][k] + graph[k][j]
                anGraph[i][j] = anGraph[i][k]

for i in range(1, n+1):
    for j in range(1, n+1):
        print(anGraph[i][j], end=" ")
    print()