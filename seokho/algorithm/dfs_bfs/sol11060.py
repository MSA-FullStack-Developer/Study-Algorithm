from collections import deque

N = int(input().rstrip())
A = list(map(int, input().rstrip().split()))

start = 0
count = 0
end = len(A)-1
visited = [False for i in range(len(A))]

# BFS
queue = deque()
queue.append((start, A[start], count))
answer = 0
flag = False
while queue:
    st, temp, c = queue.popleft()
    visited[st] = True
    if st >= end:
        answer = c
        flag = True
        break
    c += 1
    for i in range(st+1, st+temp+1):
        nl = i
        if nl <= end and visited[nl] == False:
            queue.append((nl, A[nl], c))
        else:
            break

if flag == False:
    print(-1)
else:
    print(answer)
