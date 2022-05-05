import sys

input = sys.stdin.readline

n = int(input())
m = int(input())
INF = float('inf')
dist = [[INF] * (n+1) for i in range(n+1)]

for i in range(1, n+1):
    dist[i][i] = 0

for i in range(m):
    a, b, c = map(int, input().split())
    dist[a][b] = min(c, dist[a][b])

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
print(dist)
