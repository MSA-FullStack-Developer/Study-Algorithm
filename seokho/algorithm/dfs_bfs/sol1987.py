import sys

input = sys.stdin.readline

R, C = map(int, input().split())

stamp = []

stack = []

board = []
visited = [[False] * (C) for _ in range(R)]

for i in range(R):
    board.append(list(input().rstrip()))

stack.append((0, 0))
visited[0][0] = True

stamp.append(board[0][0])

mx = [-1, 1, 0, 0]
my = [0, 0, -1, 1]

while stack:
    x, y = stack.pop()
    visited[x][y] = True

    for i in range(4):
        nx = x + mx[i]
        ny = y + my[i]
        if 0 <= nx < R and 0 <= ny < C and board[nx][ny] not in stamp:
            stack.append((nx, ny))
            stamp.append(board[nx][ny])
            visited[nx][ny] = True

print(stamp)
