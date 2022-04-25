# BFS / DFS
# 단지 번호 붙이기
n = int(input())
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

# -----------------입력------------------


def dfs(x, y):
    stack = []
    home_cnt = 1 # 단지내 집 개수
    stack.append([x, y])
    graph[x][y] = 2 # 해당 노드 방문처리
    dx = [-1, 0, 1, 0]  # 상 하 좌 우
    dy = [0, -1, 0, 1]

    while stack: # 스택이 빌 때 까지 반복
        v = stack.pop()
        for i in range(4): #현재 노드에서 상하좌우 탐색

            nx = v[0] + dx[i]
            ny = v[1] + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >=n: #범위를 벗어난 경우
                continue

            if graph[nx][ny] == 1: # 다음 노드가 방문가능하다면
                stack.append([nx, ny]) # 스택에 넣어주고
                graph[nx][ny] = 2 # 방문처리
                home_cnt += 1
    home_in_block.append(home_cnt) #단지별 집 개수를 넣어줌


block = 0 # 단지 수
home_in_block = [] # 단지별 집 개수를 담은 배열
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            dfs(i,j)
            block += 1

print(block)
home_in_block.sort()
for h in home_in_block:
    print(h)