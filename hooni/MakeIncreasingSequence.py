    
from inspect import stack
import sys
# sys.stdin=open("./in3.txt", "r")
n = int(input())
a=list(map(int, input().split()))
stack = list()
res = ''
lt = 0
rt = len(a) - 1
while lt < rt:
    if(a[lt] <= a[rt] and not stack):
        stack.append(a[lt])
        lt += 1
        res += 'L'
    elif(a[lt] > a[rt] and not stack):
        stack.append(a[rt])
        rt -= 1
        res += 'R'
    elif(stack[-1] < a[lt] or stack[-1] < a[rt]):
        if(stack[-1] < a[rt] and stack[-1] < a[lt]):
            if(a[lt] < a[rt]):
                stack.append(a[lt])
                lt += 1
                res += 'L'
            else:
                stack.append(a[rt])
                rt -= 1
                res += 'R'
        else:
            if(a[lt] > a[rt]):
                stack.append(a[lt])
                lt += 1
                res += 'L'
            else:
                stack.append(a[rt])
                rt -= 1
                res += 'R'
    else:
        break
   

print(len(stack))
print(res)

# import sys
# sys.stdin=open("input.txt", "r")
# n=int(input())
# a=list(map(int, input().split()))
# lt=0
# rt=n-1
# last=0
# res=""
# tmp=[]
# while lt<=rt:
#     if a[lt]>last:
#         tmp.append((a[lt], 'L'))
#     if a[rt]>last:
#         tmp.append((a[rt], 'R'))
#     tmp.sort()
#     if len(tmp)==0:
#         break;
#     else:
#         res=res+tmp[0][1]
#         last=tmp[0][0]
#         if tmp[0][1]=='L':
#             lt=lt+1
#         else:
#             rt=rt-1
#     tmp.clear()

# print(len(res))
# print(res)

# 내 풀이는 1차원적으로 생각해서 수열을 저장할 리스트를 놓고 그 안에 수열을 넣으면서 마지막 값과 비교하는 방식으로 진행했지만
# 인프런 강의 풀이에서는 튜플자료구조를 이용해서 간단하게 풀었다.
