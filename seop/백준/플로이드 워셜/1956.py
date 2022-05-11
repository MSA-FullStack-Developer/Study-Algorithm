# 플로이드
# 운동
import sys
input = sys.stdin.readline

INF = int(1e9)

N, M = map(int, input().split()) #정점 수, 간선 수

# 무한으로 그래프 초기화
graph = [[INF] * N for _ in range(N)]

# 나 자신 0으로..
for i in range(N):
    for j in range(N):
        if i == j:
            graph[i][j] = 0

# 입력 받기
for _ in range(M):
    a,b,c = map(int, input().split())
    graph[a-1][b-1] = c

# 플로이드 돌려~

for k in range(N):
    for a in range(N):
        for b in range(N):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

answer = []
for i in range(N):
    for j in range(N):
        if i != j:
            if graph[i][j] != INF and graph[j][i] != INF:
                answer.append(graph[i][j] + graph[j][i])
if not answer:
    print(-1)
else:
    print(min(answer))