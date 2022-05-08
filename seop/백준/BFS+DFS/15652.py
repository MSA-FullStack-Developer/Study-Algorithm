# 백트래킹
# N 과 M (4)

N, M = map(int,input().split()) # N까지 M개

stack = []
def dfs():

    if len(stack) == M: #스택의 길이가 M이라면( 끝까지 탐색 했다면 ) (종료조건)
        print(' '.join(map(str, stack))) # 출력 하고 종료
        return

    for i in range(1,N+1):
        if not stack: # 스택에 아무것도 없다면
            stack.append(i) #스택에 넣어줌
            dfs() # 재귀호출
            stack.pop() #출력하고 스택에서 꺼내줘야함
        elif stack and i>= stack[-1]: # 스택이 존재하고 i가 스택 맨 마지막보다 크다면
            stack.append(i)
            dfs()
            stack.pop()
dfs()
