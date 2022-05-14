def solution(n, results):
    answer = 0

    INF = float('inf')
    graph = [[0] * (n+1) for _ in range(n+1)]
    visited = [[False] * (n+1) for _ in range(n+1)]

    for i, j in results:
        graph[i][j] = 1
        graph[j][i] = -1
        visited[i][j] = True
        visited[j][i] = True

    for k in range(1, n+1):
        for i in range(1, n+1):
            for j in range(1, n+1):
                if graph[i][k] == graph[k][j] and visited[i][k] and visited[k][j]:
                    if graph[i][k] == 1:
                        graph[i][j] = 1
                        visited[i][j] = True
                    else:
                        graph[i][j] = -1
                        visited[i][j] = True
    for i in graph:
        count = 0
        for j in i:
            if j != 0:
                count += 1
        if count == n-1:
            answer += 1

    return answer
