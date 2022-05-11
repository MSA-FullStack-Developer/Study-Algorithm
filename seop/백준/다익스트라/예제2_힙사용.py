import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)

#노드, 간선 개수 입력
n, m = map(int, input().split())
# 시작 노드 번호 입력
start = int(input())
# 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트
graph = [[] for _ in range(n+1)]
# 최단 거리 테이블을 모두 무한으로 초기화
distance = [INF] * (n+1)

# 간선 정보 입력
for _ in range(m):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))

def dijkstra(start):
    q = []
    # 시작 노드 최단경로 큐에 삽입
    heapq.heappush(q, (0,start)) # (거리, 노드)
    distance[start] = 0 #시작노드 거리 0으로 초기화

    while q: #큐가 빌 때 까지 반복
        #가장 거리가 짧은 노드에 대한 정보 꺼내김
        dist, now = heapq.heappop(q)
        
        # 현재 노드가 이미 처리된 적이 있다면 무시
        if distance[now] < dist:
            continue
        
        # 현재 노드와 연결된 다른 인접한 노드들을 확인
        for i in graph[now]:
            cost = dist + i[1]
            # 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost < distance[i[0]]:
                distance[i[0]] = cost #최단거리 갱신
                heapq.heappush(q, (cost, i[0])) #갱신한 거리, 노드를 넣어줌


dijkstra(start)

print(distance)