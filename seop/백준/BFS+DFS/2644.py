# DFS
# 촌수 계산

N = int(input())
x, y = map(int,input().split())
M = int(input())

graph = [[] for _ in range(N+1)]

for _ in range(M):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [0] * (N+1)
def dfs(graph, x):

    stack = []
    stack.append(x)
    visited[x] = 1 # 시작노드 방문처리

    while stack:
        v = stack.pop()
        
        for g in graph[v]: # 다음 노드 탐색
            if visited[g] == 0: # 다음 노드가 방문하지 않은 노드라면

                visited[g] = visited[v] + 1 # 방문처리(다음노드 = 현재 노드까지 거리 + 1) 후
                stack.append(g) # 스택에 넣어줌

dfs(graph,x)
if visited[y] ==0:
    print(-1)
else:
    print(visited[y]-1)