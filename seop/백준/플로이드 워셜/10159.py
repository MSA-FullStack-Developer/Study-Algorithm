# 플로이드 워셜
# 저울
import sys
input = sys.stdin.readline

INF = int(1e9)

N = int(input())
M = int(input())

# 무한 그래프 입력
graph = [[INF] * (N) for _ in range(N)]

# 나에서 나는 0으로 입력
for i in range(N):
    for j in range(N):
        if i == j:
            graph[i][j] = 0

# 예제 입력
for _ in range(M):
    a,b = map(int,input().split())
    graph[a-1][b-1] = 1

#플로이드 돌려~
for k in range(N):
    for a in range(N):
        for b in range(N):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

# 양방향으로 둘다 못가면 비교불가임
for i in range(N):
    cnt = 0
    for j in range(N):
        if graph[i][j] == INF and graph[j][i] == INF:
            cnt += 1
    print(cnt)
