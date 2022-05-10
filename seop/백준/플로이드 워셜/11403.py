# 플로이드 워셜
# 경로 찾기
import sys
input = sys.stdin.readline
INF = int(1e9)

N = int(input())

graph = []
for _ in range(N):
    graph.append(list(map(int,input().split())))

for i in range(N):
    for j in range(N):
        if graph[i][j] == 0:
            graph[i][j] = INF


for k in range(N):
    for a in range(N):
        for b in range(N):
            graph[a][b] = min(graph[a][b], graph[a][k]+graph[k][b])

for a in range(N):
    for b in range(N):
        if graph[a][b] == INF:
            print(0, end =' ')
        else:
            print(1, end=' ')
    print()
