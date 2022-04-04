    
import sys
# sys.stdin=open("./in4.txt", "r")
n, m=map(int, input().split())

a = list(map(int, str(n)))
stack = list()

for x in a:
    while stack and m > 0 and stack[-1] < x:
        stack.pop()
        m -= 1
    stack.append(x)

if m != 0:
    stack = stack[:-m]
      
res = ''.join(map(str, stack))

print(res)

#지우고 앞으로 채워나간다는 문제는 스택을 사용해서 푼다.
