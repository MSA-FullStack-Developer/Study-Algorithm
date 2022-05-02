# deque
# 덱

from collections import deque
import sys

N = int(sys.stdin.readline().rstrip())


dq = deque()

for i in range(N):
    
    v = sys.stdin.readline().split()

    if v[0] == 'push_front':
        dq.appendleft(int(v[1]))
    elif v[0] == 'push_back':
        dq.append(int(v[1]))
    elif v[0] == 'pop_front':
        if len(dq) == 0:
            print(-1)
        else:
            print(dq.popleft())
    elif v[0] == 'pop_back':
        if len(dq) == 0:
            print(-1)
        else:
            print(dq.pop())
    elif v[0] == 'size':
        print(len(dq))
    elif v[0] == 'empty':
        if len(dq) == 0:
            print(1)
        else:
            print(0)
    elif v[0] == 'front':
        if len(dq) == 0:
            print(-1)
        else:
            print(dq[0])
    elif v[0] == 'back':
        if len(dq) == 0:
            print(-1)
        else:
            print(dq[-1])

# sys.stdin.readline() 사용해야 시간초과 안뜸..