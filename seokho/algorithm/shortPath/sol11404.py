# 도시 수
n = int(input())

# 버스 수
m = int(input())

INF = float('inf')
graph = [[INF] * (n+1) for _ in range(n+1)]
for a in range(1, n+1):
    for b in range(1, n+1):
        if a == b:
            graph[a][b] = 0


for _ in range(m):
    a, b, cost = map(int, input().rstrip().split())
    graph[a][b] = min(graph[a][b], cost)

for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

for i in range(1, n+1):
    for j in range(1, n+1):
        if graph[i][j] == INF:
            graph[i][j] = 0

for i in range(1, n+1):
    for j in range(1, n+1):
        print(graph[i][j], end=" ")
    print()
