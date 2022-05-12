import sys
import heapq
input = sys.stdin.readline

N = int(input())
M = int(input())

INF = float('inf')
dist = [INF] * (N+1)

graph = [[] for _ in range(N+1)]

for i in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((c, b))
S, E = map(int, input().split())

q = []
def dijkstra(start):
    dist[start] = 0
    heapq.heappush(q, (dist[start], start))
    while q:
        new_dist, now = heapq.heappop(q)
        if dist[now] < new_dist:
            continue
        for nd, new_now in graph[now]:
            cost = new_dist + nd
            if cost < dist[new_now]:
                dist[new_now] = cost
                heapq.heappush(q, (cost, new_now))

dijkstra(S)
print(dist[E])