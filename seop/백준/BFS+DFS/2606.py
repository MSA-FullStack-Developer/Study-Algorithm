# DFS
# 바이러스

N = int(input())
M = int(input())

graph = [[] for _ in range(N+1)] # 그래프 정보
visited = [False for _ in range(N+1)] # 방문 정보 

for _ in range(M): # 인접 리스트 방식 그래프 초기화
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(graph, start, visited):

    stack = []
    stack.append(start)
    visited[start] = True # 시작노드 방문처리
    virus = 0 # 감염된 컴퓨터 수

    while stack:
        v = stack.pop()
        
        for i in graph[v]: # 연결된 노드 탐색
            if visited[i] == False: # 방문하지 않았다면
                stack.append(i) #스택에 넣어주고
                visited[i] = True # 방문처리
                virus += 1 # 연결되어있으니까 바이러스 감염됨.
    print(virus)

dfs(graph, 1, visited)