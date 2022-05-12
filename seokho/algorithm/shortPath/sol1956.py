import sys

input = sys.stdin.readline

V, E = map(int, input().split())

INF = float('inf')
graph = [[INF] * (V+1) for _ in range((V+1))]


for i in range(E):
    a, b, c = map(int, input().split())
    graph[a][b] = c

for k in range(1, V+1):
    for i in range(1, V+1):
        for j in range(1, V+1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

answer = []
for i in range(1, V+1):
    if graph[i][i] != float('inf'):
        answer.append(graph[i][i])

if answer:
    print(min(answer))
else:
    print(-1)
