import sys
from collections import deque

input = sys.stdin.readline

R, C = map(int, input().split())

around = [[False] * (C) for _ in range(R)]
graph = []
for i in range(R):
    graph.append(list(map(int, input().split())))

# 상, 하, 좌, 우
mx = [-1, 1, 0, 0]
my = [0, 0, -1, 1]
answer = -1
# 치즈의 겉 부분을 확인하기 위한 bfs함수 (처음 시작을 위해 방문한곳을 방문처리한다.)


def findEnd(graph, q):
    while q:
        x, y = q.popleft()
        around[x][y] = True
        for i in range(4):
            nx = x + mx[i]
            ny = y + my[i]
            if 0 <= nx < R and 0 <= ny < C and not around[nx][ny] and graph[nx][ny] == 0:
                around[nx][ny] = True
                q.append((nx, ny))


# 현재 그래프의 총 합을 리턴하는 함수
def totalSum(graph):
    ssum = 0
    for i in range(R):
        for j in range(C):
            if graph[i][j] == 1:
                ssum += 1
    return ssum


total_count = totalSum(graph)


def pr(graph):
    for i in range(len(graph)):
        print(graph[i])
    print()


ans = 0
q = deque()
q.append((0, 0))
while total_count != 0:
    findEnd(graph, q)
    answer += 1
    ans = totalSum(graph)
    for i in range(R):
        for j in range(C):
            if graph[i][j] == 1:
                for m in range(4):
                    nx = i + mx[m]
                    ny = j + my[m]
                    if around[nx][ny] == True:
                        graph[i][j] = 0
                        q.append((i, j))
                        break
    total_count = totalSum(graph)

print(answer+1)
print(ans)
