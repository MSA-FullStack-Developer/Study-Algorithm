# 플로이드 워셜
# 끝나지 않는 파티
import sys

input = sys.stdin.readline

N, M = map(int,input().split())

# 그래프 입력
graph = []
for _ in range(N):
    graph.append(list(map(int,input().split())))

# 플로이드 알고리즘 수행
for k in range(N):
    for a in range(N):
        for b in range(N):
            graph[a][b] = min(graph[a][b], graph[a][k]+graph[k][b])

for _ in range(M):
    a, b, c = map(int,input().split())
    if graph[a-1][b-1] > c:
        print('Stay here')
    else:
        print('Enjoy other party')