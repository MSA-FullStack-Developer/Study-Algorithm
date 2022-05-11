# 플로이드 워셜
# 서강그라운드
import sys
input = sys.stdin.readline

INF = int(1e9)

N, M, R = map(int,input().split()) # 지역 개수, 수색 범위, 길의 개수
region = list(map(int,input().split())) #지역에 있는 아이템 수

# 그래프 초기화
graph = [[INF] * N for _ in range(N)]

# 나는 0으로 초기화
for i in range(N):
    for j in range(N):
        if i == j:
            graph[i][j] = 0

# 입력 받기 (양방향임)
for _ in range(R):
    a,b,c = map(int,input().split())
    graph[a-1][b-1] = c
    graph[b-1][a-1] = c

# 플로이드 돌려버리기~
for k in range(N):
    for a in range(N):
        for b in range(N):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

# 수색범위가 M보다 작으면 아이템을 얻을 수 있으니까
# 가능한 수색범위 내에 있는 아이템들을 다 더해서 리스트에 넣음
# 리스트에는 해당 인덱스에서 최대 몇 개의 아이템을 주울 수 있는지 갯수가 들어가있음
answer = 0
for g in graph:
    cnt = 0
    for i in range(N):
        if g[i] <= M:
            cnt += region[i]
    answer = max(answer,cnt)
print(answer)