# BFS
# 스타트 링크

# F : 최대 층수
# S : 현재 위치
# G : 가야할 층
# U : 위로 갈 수 있는 층수
# D : 아래로 갈 수 있는 층수
F, S, G, U, D = map(int,input().split())

from collections import deque

queue = deque()
queue.append(S)
visited = [0]*(F+1) # 해당 층까지 얼마나 걸리나 저장할 리스트
visited[S] = 1

while queue:
    
    v = queue.popleft() #현재 층

    d = v-D
    u = v+U

    if v == G:
        break
    
    for nv in [d,u]:
        if 0 < nv <= F and visited[nv] == 0: #다음 층이 범위 내에 있다면
            visited[nv] = visited[v] + 1
            queue.append(nv)


visited[S] = 'x'

if visited[G] == 0:
    print('use the stairs')
elif visited[G] == 'x':
    print(0)
else:
    print(visited[G]-1)