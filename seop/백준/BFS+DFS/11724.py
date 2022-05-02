# DFS
# 연결 요소의 개수

N, M = map(int,input().split())

graph = [[] for _ in range(N+1)]

for i in range(M):
    a,b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


visited = set()
visited.add(0)

def dfs(x):
    
    stack = []
    stack.append(x)
    
    while stack:
        v = stack.pop()

        for i in graph[v]: # 연결 노드 탐색
            if i not in visited: # 방문하지 않은 노드라면
                visited.add(i) # 방문처리 후
                stack.append(i)

cnt = 0
for i in range(N+1):
    if i not in visited:
        dfs(i)
        cnt += 1
print(cnt)

# PyPy3로..