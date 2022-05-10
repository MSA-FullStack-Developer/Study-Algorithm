INF = int(1e9)

#노드 개수 및 간선 개수입력
N = int(input()) #노드 개수
M = int(input()) #간선 개수

# 2차원 리스트 생성 (무한으로 초기화)
graph = [[INF] * (N+1) for _ in range(N+1)]

# 자기 자신에서 자기 자신으로 가는 비용 0으로 초기화
for a in range(1, N+1):
    for b in range(1, N+1):
        if a == b:
            graph[a][b] = 0

for g in graph:
    print(g)


# 간선에 대한 정보를 입력받아 초기화함
for _ in range(M):
    # a에서 b로 가는 비용은 c로 설정
    a,b,c = map(int, input().split())
    graph[a][b] = c


for k in range(N+1):
    for a in range(N+1):
        for b in range(N+1):
            graph[a][b] = min(graph[a][b], graph[a][k]+graph[k][b])

print("-----------")

for a in range(1, N+1):
    for b in range(1, N+1):
        # 무한일 경우
        if graph[a][b] == INF:
            print("INF", end=" ")
        else:
            print(graph[a][b], end=" ")
    print()