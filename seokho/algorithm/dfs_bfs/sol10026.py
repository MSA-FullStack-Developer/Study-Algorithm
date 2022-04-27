import sys


def dfs(graph, visited, i, j):
    global count
    stack = []
    stack.append((i, j))
    count += 1
    while stack:
        y1, x1 = stack.pop()
        visited[y1][x1] = 1
        for m in range(4):
            ny = y1 + my[m]
            nx = x1 + mx[m]
            if 0 <= ny < n and 0 <= nx < n:
                if visited[ny][nx] == 0 and graph[y1][x1] == graph[ny][nx]:
                    visited[ny][nx] = 1
                    stack.append((ny, nx))


if __name__ == "__main__":
    input = sys.stdin.readline
    n = int(input().rstrip())
    count = 0

    #상, 하, 좌, 우
    my = [-1, 1, 0, 0]
    mx = [0, 0, -1, 1]

    # 적록색맹 아닌사람 그래프
    graph = []
    for i in range(n):
        graph.append(list(input().rstrip()))
    # 적록색맹인사람  그래프
    graph1 = []
    for i in range(n):
        temp = ""
        for j in range(n):
            temp += graph[i][j].replace("R", "G")
        graph1.append(list(temp))

    visited = [[0 for i in range(n)] for j in range(n)]
    for i in range(n):
        for j in range(n):
            if visited[i][j] == 0:
                dfs(graph, visited, i, j)
    a = count
    # 카운트 초기화
    count = 0
    visited = [[0 for i in range(n)] for j in range(n)]
    for i in range(n):
        for j in range(n):
            if visited[i][j] == 0:
                dfs(graph1, visited, i, j)
    b = count
    print(a, b)
