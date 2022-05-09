# DFS
# 트리의 지름

# 1. 트리의 시작노드는 가운데노드라서 여기서부터 가장 먼 노드를 찾음.
# 2. 위에서 찾은 가장 먼 노드에서 가장 먼 노드가 트리의 지름.
# 3. dfs(노드, 길이) 는 시작 노드부터 연결된 노드들을 전부 돌면서
#    해당 노드까지 얼마나 걸리는지 visited에 기록해줌.(visited의 인덱스는 해당 노드 번호임)
# 4. 1(트리 시작점)부터 시작해서 가장 dfs(1,0)으로 가장 먼 노드를 구함
# 5. visited를 초기화 하고 가장 먼 노드를 시작점으로 다시한번 dfs(start,0)을 해주면 해당 노드부터 가장 먼 노드를 찾을 수 있음.
# 6. visited에 저장된 가장 큰 수를 출력 


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
print(visited)
# 1번 노드에서 가장 먼 노드에서 가장 먼 노드 찾기 (이러면 최대임)
visited = [-1]*(N+1)
visited[start] = 0
dfs(start,0)
print(max(visited))
