from cmath import cos
from dis import dis
import sys
import heapq
input = sys.stdin.readline

# N 마을/학생 수, M 도로의 수 , X 번 마을에서 파티한다.
N, M, X = map(int, input().split())

INF = float('inf')
distance = [INF] * (N+1)

graph = [[] for _ in range(N+1)]

for i in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((c, b))

q = []


def dijkstra(start):
    distance[start] = 0
    heapq.heappush(q, (0, start))
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for new_dist, new_now in graph[now]:
            cost = dist + new_dist
            if distance[new_now] > cost:
                distance[new_now] = cost
                heapq.heappush(q, (cost, new_now))


answer = [[] for _ in range(N+1)]
for i in range(1, N+1):
    distance = [INF] * (N+1)
    dijkstra(i)
    answer[i].append(distance[X])
    distance = [INF] * (N+1)
    dijkstra(X)
    answer[i].append(distance[i])

ans = 0
for i in answer:
    if ans < sum(i):
        ans = sum(i)

print(ans)
