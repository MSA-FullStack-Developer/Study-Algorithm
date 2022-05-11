# 다익스트라
# 최단 경로
import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)

N, E = map(int,input().split())
K = int(input())

#각 노드까지 최단 거리를 저장할 리스트
distance = [INF] * (N+1)

# 모든 간선 정보 입력
graph = [[] for _ in range(N+1)]
for _ in range(E):
    a, b, c = map(int, input().split())
    graph[a].append((b,c)) #a -> b, 비용c

def djikstra(start):
    q = [] #우선순위 큐로 사용
    heapq.heappush(q, (0, start)) #시작 노드 설정 (비용, 노드으로 넣어줌)
    distance[start] = 0
    
    while q: #우선순위 큐가 빌 때 까지
        
        # 비용이 가장 짧은 노드를 꺼냄
        dist, now = heapq.heappop(q) #현재 노드까지 비용, 현재 노드

        if distance[now] < dist: #기록되어 있는 노드가 꺼낸 노드까지의 거리가 작으면
            continue             # 무시
        
        #인접 노드 탐색
        for i in graph[now]:
            cost = dist + i[1] #  현재 노드까지 비용 + 인접노드까지 비용
            if cost < distance[i[0]]: # 인접노드까지 비용이 기록된 비용보다 작다면
                distance[i[0]] = cost # 최단거리 갱신
                heapq.heappush(q, (cost, i[0])) # 비용, 인접노드 를 우선순위 큐에 넣어줌
        
djikstra(K)

for i in range(1, N+1):
    if distance[i] == INF:
        print('INF')
    else:
        print(distance[i])