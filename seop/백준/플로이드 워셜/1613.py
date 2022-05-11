# 플로이드 워셜
# 역사
import sys
input = sys.stdin.readline

INF = int(1e9)

N, K = map(int, input().split())

# 무한 그래프 초기화
graph = [[INF] * N for _ in range(N)]

# 나 0으로
for i in range(N):
    for j in range(N):
        if i == j:
            graph[i][j] = 0

#그래프 입력 받기
for _ in range(K):
    a,b = map(int, input().split())
    graph[a-1][b-1] = 1

# 플로이드 
for k in range(N):
    for a in range(N):
        for b in range(N):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])


S = int(input())

for _ in range(S):
    i,j = map(int, input().split())
    i -= 1
    j -= 1
    if graph[i][j] == INF and graph[j][i] == INF:
        print(0)
    elif graph[i][j] == INF and graph[j][i] != INF:
        print(1)
    elif graph[i][j] != INF and graph[j][i] == INF:
        print(-1)