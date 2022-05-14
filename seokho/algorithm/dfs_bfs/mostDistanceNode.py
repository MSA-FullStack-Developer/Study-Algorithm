from collections import deque


def solution(n, edge):
    m = 0
    ans = []
    answer = 0
    graph = [[] * (n+1) for _ in range(n+1)]
    visited = [False] * (n+1)
    for a, b in edge:
        graph[a].append(b)
        graph[b].append(a)

    q = deque()
    q.append((1, 0))
    while q:
        temp, c = q.popleft()
        ans.append(c)
        if m < c:
            m = c
        visited[temp] = True
        for i in graph[temp]:
            if visited[i] == False:
                visited[i] = True
                q.append((i, c+1))

    for i in ans:
        if i == m:
            answer += 1
    return answer
