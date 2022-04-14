# n, m 을 공백으로 구분하여 입력 받기
n, m = map(int, input().split())

# 맵 받기
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

# DFS로 특정 노드 방문 뒤 연결된 모든 노드 방문하기


def dfs(x, y):
    # 주어진 범위를 벗어나면 바로 종료
    if x <= -1 or x >= n or y <= -1 or y >= m:
        return False
    # 현재 노드를 아직 방문하지 않았다면
    if graph[x][y] == 0:
        # 방문처리하기
        graph[x][y] = 1
        # 상하좌우 재귀호출
        dfs(x-1, y)
        dfs(x, y-1)
        dfs(x+1, y)
        dfs(x, y+1)
        return True
    return False


# 모든 노드에 대해 음료수 채우기
result = 0
for i in range(n):
    for j in range(m):
        if dfs(i, j) == True:
            result += 1

print(result)
