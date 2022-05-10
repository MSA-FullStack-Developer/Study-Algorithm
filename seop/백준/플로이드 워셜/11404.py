# 플로이드 워셜
# 플로이드
import sys
input = sys.stdin.readline

INF = int(1e9)

# 정점 개수 입력
N = int(input())
M = int(input())

# 무한대 그래프 초기화
graph = [[INF] * (N+1) for _ in range(N+1)]


# 자기 자신 0으로 초기화
for i in range(N+1):
    for j in range(N+1):
        if i == j:
            graph[i][j] = 0

# 입력 초기화
for _ in range(M):
    a,b,c = map(int,input().split())
    graph[a][b] = min(graph[a][b], c)

# 최단경로 찾기
for k in range(N+1):
    for a in range(N+1):
        for b in range(N+1):
            graph[a][b] = min(graph[a][b], graph[a][k]+graph[k][b])

for i in range(1,N+1):
    for j in range(1,N+1):
        if graph[i][j] == INF:
            print(0, end=' ')
        else:
            print(graph[i][j], end=' ')
    print()