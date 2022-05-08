# DFS
# 트리의 지름
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**5) # 재귀 깊이 설정

N = int(input())

graph = [[] for _ in range(N+1)]
visited = [-1]*(N+1)
visited[1] = 0
for _ in range(N-1):
    a, b, c  = map(int,input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))


def dfs(x, length):

    for g in graph[x]: #다음 노드 탐색
        if visited[g[0]] == -1: # 다음 노드가 방문하지 않은 노드라면
            visited[g[0]] = length + g[1] #방문처리 (+거리)
            dfs(g[0],length+g[1]) # 재귀 호출


# 1번 노드에서 가장 먼 노드 찾기
dfs(1,0)
start = visited.index(max(visited))

# 1번 노드에서 가장 먼 노드에서 가장 먼 노드 찾기 (이러면 최대임)
visited = [-1]*(N+1)
visited[start] = 0
dfs(start,0)
print(max(visited))
