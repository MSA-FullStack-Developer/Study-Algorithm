from re import L
import sys

input = sys.stdin.readline

score = []

N = int(input())

INF = float('inf')

graph = [[INF] * (N+1) for _ in range(N+1)]

for i in range(1, N+1):
    for j in range(1, N+1):
        if i == j:
            graph[i][j] = 0


while True:
    a, b = map(int, input().split())
    if a == -1 and b == -1:
        break
    graph[a][b] = graph[b][a] = 1

for k in range(1, N+1):
    for i in range(1, N+1):
        for j in range(1, N+1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

print(graph)

for i in range(N+1):
    for j in range(N+1):
        if graph[i][j] == float('inf'):
            graph[i][j] = 0

for i in range(1, N+1):
    score.append(max(graph[i]))

p = min(score)
pc = 0
ans = []
for i, val in enumerate(score):
    if val == p:
        pc += 1
        ans.append(i+1)
print(p, pc)
for i in ans:
    print(i, end=" ")
