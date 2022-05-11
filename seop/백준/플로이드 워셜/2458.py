# 플로이드 워셜
# 키 순서
import sys
input = sys.stdin.readline

INF = int(1e9)

N, M = map(int, input().split())

# 그래프 무한으로 초기화
graph = [[INF] * N for _ in range(N)]

# 나 자신 0으로 설정
for i in range(N):
    for j in range(N):
        if i == j:
            graph[i][j] = 0

# 연결 정보 입력 받기
for i in range(M):
    a,b = map(int,input().split())
    graph[a-1][b-1] = 1

# 플로이드 조지기
for k in range(N):
    for a in range(N):
        for b in range(N):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

# 
answer = 0
for i in range(N):
    cnt = 0
    for j in range(N):
        if i != j:
            if graph[i][j] != INF or graph[j][i] != INF:
                cnt += 1

    if cnt == N-1:
        answer += 1

print(answer)