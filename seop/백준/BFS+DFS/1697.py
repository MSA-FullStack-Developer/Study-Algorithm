# BFS
# 숨바꼭질

from collections import deque

N, K = map(int, input().split())

def bfs(start, end):
    visited = [0] * 100001 # 방문한 번호(해당 번호까지 몇 초 걸리는지 저장해둠)

    queue = deque([])
    queue.append(start)

    while True:
        v = queue.popleft()

        if v == end: # 큐에서 뽑은게 도착숫자면 그 번호까지 걸리는 시간을 리턴해줌
            return visited[v]
        
        if v-1 >= 0 and visited[v-1] == 0: # -1하는 경우
            visited[v-1] = visited[v] + 1 # 해당 번호까지 걸리는 시간 + 1
            queue.append(v-1)
        
        if v+1 <= 100000 and visited[v+1] == 0: # +1하는 경우
            visited[v+1] = visited[v] + 1
            queue.append(v+1)
        
        if  v*2 <= 100000 and visited[v*2] == 0: # *2하는 경우
            visited[v*2]= visited[v] + 1
            queue.append(v*2)


print(bfs(N,K))