# DFS
# ABCDE 두번째품

N, M = map(int,input().split())

graph = [[] for _ in range(N+1)]
for _ in range(M):
    a, b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = []
def dfs(visited, x):

    if len(visited) > 4:
        print(1)
        exit(0)

    for g in graph[x]: # 다음 노드 탐색
        if g not in visited: # 다음 노드가 방문하지 않은 노드라면
            visited.append(g) # 방문처리
            dfs(visited, g) # 재귀호출
            visited.pop() 

for i in range(N):
    visited.append(i)
    dfs(visited, i)
    visited = []

print(0)