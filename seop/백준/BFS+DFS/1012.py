# DFS
#유기농 배추

import sys
sys.setrecursionlimit(10**6) # 재귀 깊이 설정

T = int(input())

def dfs(x,y):
    
    graph[x][y] = 0 #처음노드 방문처리

    dx = [-1,1,0,0]
    dy = [0,0,-1,1]

    for i in range(4): #다음 노드 탐색
        nx = x + dx[i]
        ny = y + dy[i]

        if nx >= N or nx < 0 or ny >= M or ny < 0: # 범위를 벗어날 경우 무시
            continue
        
        if graph[nx][ny] == 1: # 다음 노드가 방문하지 않은 노드라면
            graph[nx][ny] = 0 # 방문처리
            dfs(nx,ny) # 재귀호출

for _ in range(T):
    M, N, K = map(int, input().split()) # M = 가로길이, N = 세로길이
    graph = [[0]*M for _ in range(N)]

    for _ in range(K):
        Y,X = map(int, input().split())
        graph[X][Y] = 1
    
    cnt = 0
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 1:
                dfs(i,j)
                cnt += 1
    print(cnt)