
import sys
# sys.stdin=open("./in1.txt", "r")
m, n= map(int, input().split())
from collections import deque
a = deque(x+1 for x in range(m))
res = deque()
i = 1
while True:
    if(len(a) == 1 or len(res) == 1):
        break
    if a:
        while a:
            if i == n:
                i = 1
                a.popleft()
            else:
                i += 1
                res.append(a.popleft())
    else:
        while res:
            if i == n:
                i = 1
                res.popleft()
            else:
                i += 1
                a.append(res.popleft())
    
if a:
    print(a[0])
else:
    print(res[0])


