import sys
import heapq
input = sys.stdin.readline

V, E = map(int, input().split())

K = int(input())

INF = float('inf')

dist = [INF] * (V+1)

graph = [[] for _ in range(V+1)]

for i in range(E):
    u, v, w = map(int, input().split())
    graph[u].append((w, v))

print(graph)

q = []


def dijkstra(start):
    dist[start] = 0
    heapq.heappush(q, (0, start))
    while q:
        new_dist, now = heapq.heappop(q)
        if dist[now] < new_dist:
            continue
        for weight, now_now in graph[now]:
            cost = new_dist + weight
            if cost < dist[now_now]:
                dist[now_now] = cost
                heapq.heappush(q, (cost, now_now))


dijkstra(K)

print(dist)
