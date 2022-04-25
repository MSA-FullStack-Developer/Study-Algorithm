#BFS

from collections import deque

N, M = map(int,input().split()) # 헛간 , 길

data = [0 for _ in range(N+1)] # 해당 번호까지 얼마나 걸리는지 저장할 리스트
graph = [[] for _ in range(N+1)]  

for i in range(M): # 그래프 만들기
    A_i, B_i = map(int,input().split())
    graph[A_i].append(B_i)
    graph[B_i].append(A_i)


def bfs(start):
    
    queue = deque()
    queue.append(start)
    while queue:
        v = queue.popleft()
        
        for i in graph[v]:
            if data[i] == 0: # 방문하지 않았다면..
                data[i] = data[v]+1
                queue.append(i)
    data[start] = 0 # 이거 안해주면 틀림..
bfs(1)

maxx = max(data)
print(data.index(maxx), maxx, data.count(maxx))