import sys
import heapq
input = sys.stdin.readline

N, K = map(int, input().split())

INF = float('inf')
dist = [INF] * 100001

count = 0
moves = [2, 1, -1]
q = []


def dijkstra(start):
    dist[start] = 0
    heapq.heappush(q, (dist[start], start))
    while q:
        d, now = heapq.heappop(q)
        if dist[now] < d:
            continue
        if now == K:
            return

        for i in range(3):
            if i == 0:
                nx = now * moves[i]
                p_dist = 0
            else:
                nx = now + moves[i]
                p_dist = 1
            if nx < 0 or nx > 100000:
                continue
            total_dist = p_dist + d
            if dist[nx] > total_dist:
                dist[nx] = total_dist
                heapq.heappush(q, (total_dist, nx))


dijkstra(N)
print(dist[K])
