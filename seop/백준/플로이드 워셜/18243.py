# 플로이드 워셜
# Small World Network
import sys
input = sys.stdin.readline

INF = int(1e9)

N, M = map(int,input().split())

# 무한으로 그래프 초기화
graph = [[INF] * (N + 1) for _ in range(N+1)]


# 자기 자신은 0으로 바꿔줌
for i in range(N+1):
    for j in range(N+1):
        if i == j:
            graph[i][j] = 0

# 입력
for _ in range(M):
    a, b = map(int,input().split())
    graph[a][b] = 1
    graph[b][a] = 1


#플로이드
for k in range(N+1):
    for a in range(N+1):
        for b in range(N+1):
            graph[a][b] = min(graph[a][b], graph[a][k]+graph[k][b])

cnt = 0
for i in range(1,N+1):
    for j in range(1,N+1):
        if graph[i][j] == 1:
            cnt += 1


for i in range(1,N+1):
    for j in range(1,N+1):
        if graph[i][j] > 6 or graph[i][j] == INF:
            print('Big World!')
            exit(0)

print('Small World!')       
