
import sys
# sys.stdin=open("./in1.txt", "r")
str_input = input()
a = list(str_input[:])
pop_check = False
stack = list()
cnt = 0
ck = 0
last_t = ''
for i in a:
    stack.append(i)
    if(stack[-1] == ')' and last_t == '('):
        stack.pop()
        stack.pop()
        cnt += len(stack)
    elif(stack[-1]==')' and last_t != '('):
        stack.pop()
        stack.pop()
        cnt += 1
    last_t = i

print(cnt)

#괄호 에 대한 문제는 거의 대부분 스택으로 해결한다. 문제조건을 잘 해결해보기.

# import sys
# sys.stdin=open("input.txt", "r")
# s=input()
# stack=[]
# cnt=0
# for i in range(len(s)):
#     if s[i]=='(':
#         stack.append(s[i])
#     else:
#         stack.pop()
#         if s[i-1]=='(':
#             cnt+=len(stack)
#         else:
#             cnt+=1
# print(cnt)
