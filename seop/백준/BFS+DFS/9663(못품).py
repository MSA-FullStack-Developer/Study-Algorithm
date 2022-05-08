# 백트래킹
# N - Queen

N = int(input())

visited = [[0]*N for _ in range(N)]
print(visited)

def notQueen(visited, x, y, N):
    visited[x][y] = 1

    for i in range(N): # 세로
        visited[i][y] = 1
        
        dx = [i,i]
        dy = [-i,i]
        for j in range(2):
            nx = x + dx[j]
            ny = y + dy[j]
            if nx >= N or ny >= N or nx < 0 or ny < 0:
                continue
            visited[nx][ny] = 1


s = 1
answer = 0
def dfs(visited,a,N): # a는 행
    global s
    global answer

    if s == N:
        answer += 1
        return

    for j in range(N): # j는 열
        if a == 0:
            visited = [[0]*N for _ in range(N)]

        if visited[a][j] == 0:
            s += 1
            notQueen(visited, a, j, N)
            for v in visited:
                print(v)
            print(s)
            print('-------')
            
            dfs(visited,a+1,N)
            s -= 1

dfs(visited,0,N)
print(answer)



# notQueen(visited, 0, 1, N)
# for v in visited:
#     print(v)