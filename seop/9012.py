n = int(input())
data = [] 
for i in range(n):
    data.append(list(input())) 

# -----------------입력받기------------------

for vps in data:
    stack = []
    for i in range(len(vps)):
        if vps[i] == '(': # '('가 나온다면
            stack.append('(') # 스택에 추가
        else: # ')'가 나온다면
            if stack and stack[-1] == '(': #스택이 비어있지 않고, 마지막이 '('면
                stack.pop();
            else:
                stack.append(')')
    if not stack: # 스택이 비어있으면
        print('YES')
    else:
        print('NO')
