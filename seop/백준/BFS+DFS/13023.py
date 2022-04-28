# DFS
# ABCDE
from collections import deque

N, M = map(int,input().split())

graph = [[] for _ in range(N)]

for _ in range(M):
    a,b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [0] * N

def dfs(start, cnt):
    
    if cnt == 4: #cnt가 4가 넘으면 바로 리턴
        print(1)
        exit()

    for g in graph[start]: # 연결노드 탐색
        if visited[g] == 0: # 방문하지 않은 노드라면
            visited[g] = 1 # 방문처리 후 
            dfs(g, cnt+1) # dfs 재귀호출
            visited[g] = 0 # 방문처리 풀어줌(다시 탐색해야하니까)

answer = 0
for i in range(N):
    visited[i] = 1 # 맨처음 방문처리 
    if dfs(i,0) == 1:
        answer = 1
    visited[i] = 0
print(answer)