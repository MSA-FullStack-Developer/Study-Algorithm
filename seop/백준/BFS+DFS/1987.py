# DFS
# 알파벳
import sys
input = sys.stdin.readline
N, M = map(int, input().split())

graph = []
for i in range(N):
	graph.append(list(sys.stdin.readline().rstrip()))

answer = 0

hist = [0]*26 # A~Z

for i in range(N):
    for j in range(M):
        graph[i][j] = ord(graph[i][j]) - ord('A')

hist[graph[0][0]] = 1

def dfs(x,y,depth):
    global answer
    
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx < 0 or nx >= N or ny < 0 or ny >= M: # 범위를 벗어나는 경우 종료
            continue
        
        # 다음 노드가 hist에 존재한다면
        if hist[graph[nx][ny]] == 1:
            answer = max(answer, depth)
            continue

        # 다음 노드를 방문하지 않았고, hist에 없다면
        if  hist[graph[nx][ny]] == 0:
            hist[graph[nx][ny]] = 1
            dfs(nx,ny,depth+1) #상하좌우 재귀호출
            hist[graph[nx][ny]] = 0

dfs(0,0,1)
print(answer)