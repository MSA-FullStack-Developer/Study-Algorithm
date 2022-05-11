# 다익스트라
# 파티
import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)


N, M, X = map(int,input().split()) #노드 수, 간선 수, 파티장 번호

# 인접 정점 정보 초기화
graph = [[] for _ in range(N+1)]
for i in range(M):
    a,b,c = map(int, input().split())
    graph[a].append((b,c)) #a에서 b로 가는 비용 c : b노드, c 비용


def djikstra(start):
    q = []
    heapq.heappush(q, (0,start)) #첫 노드를 우선순위 큐에 넣어줌 (노드, 비용)
    distance[start] = 0

    while q: #큐가 빌 때 까지
        
        #우선순위 큐에서 비용이 가장 가까운 정점을 뽑음
        dist, now = heapq.heappop(q) # 현재노드까지 비용, 현재노드
        
        if distance[now] < dist: # 현재 노드까지 기록된 거리가 현재 노드까지 비용보다 적다면
            continue #무시

        # 현재 노드에서 인접 노드 탐색
        for next, wei in graph[now]: #다음노드, 비용
            cost = dist + wei
            #현재 노드에서 인접 노드까지의 거리가 기록된 거리보다 작다면
            if cost < distance[next]:
                distance[next] = cost
                heapq.heappush(q, (cost, next))


home_party = []
for i in range(1,N+1):
    distance = [INF] * (N+1)
    djikstra(i)
    home_party.append(distance)

answer = 0
for i in range(N):
    answer = max(answer, home_party[i][X]+home_party[X-1][i+1])

print(answer)