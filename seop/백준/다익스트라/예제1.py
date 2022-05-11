import sys
input = sys.stdin.readline
INF = int(1e9)

#노드 개수, 간선 개수 입력
n, m = map(int, input().split())
# 시작 노드 번호 입력
start = int(input())

# 각 노드에 연결되어있는 노드에 대한 정보를 담는 리스트
graph = [[] for _ in range(n+1)]
# 방문한 적이 있는지 체크하는 목적의 리스트
visited = [False] * (n+1)
# 최단 거리 테이블을 모두 무한으로 초기화
distance = [INF] * (n+1)

# 모든 간선 정보 입력 (인접리스트임)
for _ in range(m):
    a,b,c = map(int, input().split())
    graph[a].append((b,c))

# 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드 번호 반환
def get_smallest_node():
    min_value = INF
    index = 0 #가장 최단거리가 짧은 노드 (인덱스)
    #1부터 노드개수까지 반복해서 최단거리가 짧은 노드를 찾음
    for i in range(1, n+1):
        if distance[i] < min_value and not visited[i]: #무한이 아니고 방문하지 않았다면
            min_value = distance[i]
            index = i
    return index

def djikstra(start):
    #시작 노드에 대해 초기화
    distance[start] = 0
    visited[start] = True
    for j in graph[start]:
        distance[j[0]] = j[1] #해당 노드까지의 거리 등록
    
    #시작 노드를 제외한 전체 n-1 개의 노드에 대해 반복
    for i in range(n-1):
        #현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문처리
        now = get_smallest_node() # (가장 거리가 짧은 노드)
        visited[now] = True
        
        #현재 노드와 연결된 다른 노드 확인
        for j in graph[now]:
            cost = distance[now] + j[1]
            #현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost < distance[j[0]]:
                distance[j[0]] = cost

djikstra(start)

print(distance)