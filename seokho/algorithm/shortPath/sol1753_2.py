from dis import dis
import sys
import heapq

input = sys.stdin.readline
INF = float('inf')
# V: 정점, E: 간선의 수
V, E = map(int, input().split())

# K: 시작 정점
K = int(input())

distance = [INF] * (V+1)
q = []
graph = [[] for _ in range(V+1)]

for _ in range(E):
    u, v, w = map(int, input().split())
    graph[u].append((w, v))


def dijkstra(start):
    distance[start] = 0
    heapq.heappush(q, (0, start))
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for new_weight, new_now in graph[now]:
            cost = dist + new_weight
            if cost < distance[new_now]:
                distance[new_now] = cost
                heapq.heappush(q, (cost, new_now))


dijkstra(K)

for i in range(1, V+1):
    if distance[i] == INF:
        print("INF")
    else:
        print(distance[i])
