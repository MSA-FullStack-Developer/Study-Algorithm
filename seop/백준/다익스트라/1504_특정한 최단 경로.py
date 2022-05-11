# 다익스트라
# 특정한 최단 경로
import sys
import heapq
input = sys.stdin.readline

INF = int(1e9)

N, E = map(int,input().split())

# 각 노드별 인접노드,비용 초기화
graph = [[] for _ in range(N+1)]
for i in range(E):
    a,b,c = map(int,input().split())
    graph[a].append((c,b)) # 비용, 다음노드
    graph[b].append((c,a))

# 해당 노드까지의 거리 무한으로 초기화
distance = [INF] * (N+1)


def djikstra(start):
    q = []
    heapq.heappush(q, (0, start)) #시작노드
    distance[start] = 0 #시작노드의 거리 0으로 초기화

    while q:
        
        dist, now = heapq.heappop(q) #비용, 현재 노드
        
        #현재 노드에서 인접 노드 탐색
        for w, next in graph[now]: #비용, 다음노드
            cost = dist + w # 시작 노드부터 현재 노드까지 비용 + 현재 노드부터 다음 노드까지 비용
            if cost < distance[next] : #다음 노드까지 비용이 기록된 것보다 적으면
                distance[next] = cost
                heapq.heappush(q, (cost, next))


v1, v2 = map(int, input().split())

answer = []
#2 -> 3 -> 4
u = 0
djikstra(1)
u+=distance[v1]
distance = [INF] * (N+1)

djikstra(v1)
u+=distance[v2]
distance = [INF] * (N+1)

djikstra(v2)
u+=distance[N]
distance = [INF] * (N+1)

answer.append(u)

# 3-> 2 -> 4
v = 0
djikstra(1)
v+=distance[v2]
distance = [INF] * (N+1)

djikstra(v2)
v+=distance[v1]
distance = [INF] * (N+1)

djikstra(v1)
v+=distance[N]
distance = [INF] * (N+1)

answer.append(v)

if min(answer) >= INF:
    print(-1)
else:
    print(min(answer))