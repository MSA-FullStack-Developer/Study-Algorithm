from enum import Flag
from re import T
import sys
from collections import deque

input = sys.stdin.readline
# 빈곳 : .   물 : *  돌 : X


# def pg(graph):
#     for i in range(R):
#         print(graph[i])
#         print()


# 상 하 좌 우
mx = [-1, 1, 0, 0]
my = [0, 0, -1, 1]

R, C = map(int, input().split())

graph = []

visited = [[False] * (C) for _ in range(R)]
wvisited = [[False] * (C) for _ in range(R)]

for i in range(R):
    graph.append(list(input().rstrip()))

q = deque()
water = deque()
# D: 비버의 굴 , S: 고슴도치
# 물과 고슴도치가 시작할 지점 찾기
end = []
for i in range(R):
    for j in range(C):
        if graph[i][j] == 'S':
            q.append((i, j, 0))
            visited[i][j] = True
        if graph[i][j] == '*':
            water.append((i, j, 0))
            wvisited[i][j] = True

flag = True
wx = wy = wc = 0
while q:

    sx, sy, sc = q.popleft()
    while water:
        if water[0][2] == sc+1:
            break
        wx, wy, wc = water.popleft()
        for i in range(4):
            wnx = wx + mx[i]
            wny = wy + my[i]
            if 0 <= wnx < R and 0 <= wny < C:
                if wvisited[wnx][wny] == False and (graph[wnx][wny] == "." or graph[wnx][wny] == "S"):
                    wvisited[wnx][wny] = True
                    graph[wnx][wny] = "*"
                    water.append((wnx, wny, wc+1))

    for i in range(4):
        snx = sx + mx[i]
        sny = sy + my[i]
        if 0 <= snx < R and 0 <= sny < C:
            if visited[snx][sny] == False and (graph[snx][sny] == "." or graph[snx][sny] == "D"):
                visited[snx][sny] = True
                q.append((snx, sny, sc+1))

    if graph[sx][sy] == "D":
        flag = False
        print(sc)
        break
if flag:
    print("KAKTUS")
