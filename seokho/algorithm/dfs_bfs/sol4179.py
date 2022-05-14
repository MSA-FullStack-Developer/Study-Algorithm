# import sys
# from collections import deque
# input = sys.stdin.readline

# # 상, 하, 좌, 우
# mx = [-1, 1, 0, 0]
# my = [0, 0, -1, 1]


# R, C = map(int, input().split())

# graph = []
# # 불 이 도달하는 시간
# fire = [[-1] * C for _ in range(R)]

# for i in range(R):
#     graph.append(list(input().rstrip()))

# for i in range(R):
#     for j in range(C):
#         if graph[i][j] == "#":
#             fire[i][j] = -1
#         if graph[i][j] == "F":
#             fire[i][j] = 0

# jq = deque()
# fq = deque()
# jVisited = [[False] * C for _ in range(R)]
# fVisited = [[False] * C for _ in range(R)]

# for i in range(R):
#     for j in range(C):
#         if graph[i][j] == "J":
#             jq.append((i, j, 0))
#             jVisited[i][j] = True
#         if fire[i][j] == 0:
#             fq.append((i, j, 0))
#             fVisited[i][j] = True


# while fq:
#     x, y, c = fq.popleft()
#     for i in range(4):
#         nx = x + mx[i]
#         ny = y + my[i]
#         if 0 <= nx < R and 0 <= ny < C:
#             if fVisited[nx][ny] == False and graph[nx][ny] == ".":
#                 fire[nx][ny] = c + 1
#                 fVisited[nx][ny] = True
#                 fq.append((nx, ny, c+1))
# flag = True
# while jq:
#     x, y, c = jq.popleft()

#     if x == 0 or x == R-1 or y == 0 or y == C-1:
#         print(c+1)
#         flag = False
#         break

#     for i in range(4):
#         nx = x + mx[i]
#         ny = y + my[i]
#         if 0 <= nx < R and 0 <= ny < C:
#             if jVisited[nx][ny] == False and graph[nx][ny] == "." and c+1 < fire[nx][ny]:
#                 jVisited[nx][ny] = True
#                 jq.append((nx, ny, c+1))


# if flag:
#     print("IMPOSSIBLE")

from collections import deque
import sys
input = sys.stdin.readline


def bfs():
    global q, f
    while q:
        temp = deque()
        while q:
            x, y = q.popleft()
            if (x == r - 1 or y == c - 1 or x == 0 or y == 0) and s[x][y] != "F":
                return s[x][y] + 1
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < r and 0 <= ny < c and s[nx][ny] == "." and s[x][y] != "F":
                    temp.append([nx, ny])
                    s[nx][ny] = s[x][y] + 1
        q = temp
        if not q:
            break
        temp = deque()
        while f:
            x, y = f.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < r and 0 <= ny < c and visit[nx][ny] == 0 and s[nx][ny] != "#":
                    temp.append([nx, ny])
                    visit[nx][ny] = 1
                    s[nx][ny] = "F"
        f = temp


dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]
r, c = map(int, input().split())
s = []
q = deque()
f = deque()
visit = [[0] * c for i in range(r)]
for i in range(r):
    a = list(input().strip())
    s.append(a)
    for j in range(c):
        if a[j] == "J":
            q.append([i, j])
            s[i][j] = 0
        elif a[j] == "F":
            f.append([i, j])
            visit[i][j] = 1
result = bfs()
print(result if result != None else "IMPOSSIBLE")
