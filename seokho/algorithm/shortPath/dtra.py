from dis import dis
import sys
import heapq

input = sys.stdin.readline

V, E = map(int, input().rstrip().split())
K = int(input())

INF = float('inf')
dist = [INF] * (V+1)

graph = [[] for i in range(V+1)]

for i in range(E):
    u, v, w = map(int, input().rstrip().split())
    graph[u].append((w, v))

print(graph)

q = []


def dijkstra(start):
    dist[start] = 0
    heapq.heappush(q, (dist[start], start))
    while q:
        new_dist, now = heapq.heappop(q)
        # 다음 위치의 경로가 이미 최단 경로인 경우
        if dist[now] < new_dist:
            continue
        for nw, nn in graph[now]:
            cost = new_dist + nw
            if cost < dist[nn]:
                dist[nn] = cost
                heapq.heappush(q, (cost, nn))


dijkstra(K)

print(dist)
