import sys
import heapq

input = sys.stdin.readline
INF = float('inf')
# V: 정점, E: 간선의 수
V, E = map(int, input().split())

# K: 시작 정점
K = int(input())

#visited = [False] * (V+1)
graph = [[] for i in range(V+1)]
visited = [False] * (V+1)

temp = [[INF] * (V+1) for _ in range(V+1)]
distance = [INF] * (V+1)

for _ in range(E):
    u, v, w = map(int, input().split())
    temp[u][v] = min(temp[u][v], w)

for i in range(1, V+1):
    for j in range(1, V+1):
        if temp[i][j] != INF:
            graph[i].append((j, temp[i][j]))

# 제일 가까운 정점
print(graph)


def smallest_Vertex():
    min_val = INF
    index = 0
    for i in range(1, V+1):
        if distance[i] < min_val and not visited[i]:
            min_val = distance[i]
            index = i
    return index


def dijkstra(start):
    distance[start] = 0
    visited[start] = True
    for j in graph[start]:
        distance[j[0]] = j[1]

    for _ in range(V-1):
        small_index = smallest_Vertex()
        visited[small_index] = True
        for j in graph[small_index]:
            cost = distance[small_index] + j[1]
            if distance[j[0]] > cost:
                distance[j[0]] = cost


dijkstra(K)

for i in range(1, V+1):
    if distance[i] == float('inf'):
        print("INF")
    else:
        print(distance[i])
