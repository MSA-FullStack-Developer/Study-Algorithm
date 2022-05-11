# 플로이드 워셜
# 회장 뽑기

import sys
input = sys.stdin.readline

N = int(input())
INF = int(1e9)

# 무한대로 그래프 초기화
graph = [[INF] * (N+1) for _ in range(N+1)]

# 자기자신 0으로 초기화
for i in range(1,N+1):
    for j in range(1,N+1):
        if i == j:
            graph[i][j] = 0


# 입력 받기
while True:
    a,b = map(int,input().split())

    if a == -1 and b == -1:
        break
    
    graph[a][b] = 1
    graph[b][a] = 1

# 플로이드 돌려~
for k in range(1,N+1):
    for a in range(1,N+1):
        for b in range(1,N+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

# 회장 후보 정보 저장
answer = []
for i in range(1,N+1):
    maxx = 0
    for j in range(1,N+1):
        if graph[i][j] == INF:
            maxx = 0
            break
        
        if graph[i][j]:
            maxx = max(maxx, graph[i][j])
    
    if maxx != 0:
        answer.append(maxx)


candidate_num = min(answer) #회장 후보의 점수
candidate_cnt = answer.count(candidate_num) # 회장 후보자 수
print(candidate_num, candidate_cnt)

candidate = []
for i in range(len(answer)): #회장 후보들을 순서대로 저장
    if answer[i] ==candidate_num:
        candidate.append(i+1)
print(' '.join(map(str,candidate)))