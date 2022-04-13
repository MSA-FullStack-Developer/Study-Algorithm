import sys
# sys.stdin=open("./in4.txt", "r")
a=input()
stack=[]
for x in a:
    if x.isdecimal():
        stack.append(int(x))
    else:
        if x=='+':
            n1=stack.pop()
            n2=stack.pop()
            stack.append(n2+n1)
        elif x=='-':
            n1=stack.pop()
            n2=stack.pop()
            stack.append(n2-n1)
        elif x=='*':
            n1=stack.pop()
            n2=stack.pop()
            stack.append(n2*n1)
        elif x=='/':
            n1=stack.pop()
            n2=stack.pop()
            stack.append(n2/n1)
print(stack[0])


# 처음에 틀렸던 점
# 빼기나 나누기 같은 경우는 숫자의 순서가 중요하기 때문에
# 처음 pop 된 수를 뒤에 놓고 그다음 pop된 수를 앞에 놓는게 중요.
