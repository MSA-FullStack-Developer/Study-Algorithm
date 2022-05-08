# 백트래킹
# N 과 M (2)

N, M = map(int,input().split()) # N까지 M개


stack = []
def dfs():
    
    if len(stack) == M: #스택의 길이가 M이라면
        print(' '.join(map(str,stack)))
        return # 멈춰줌

    for i in range(1, N+1): # 1부터 N까지 돌면서
        if not stack:
            stack.append(i) # 스택에 넣어줌
            dfs() #재귀로 다음 1~N 탐색
            stack.pop() # 재귀로 N까지 모두 탐색한 다음 빼줘야함
        elif stack and i > stack[-1]: # i가 스택의 최댓값보다 크다면
            stack.append(i) # 스택에 넣어줌
            dfs() #재귀로 다음 1~N 탐색
            stack.pop() # 재귀로 N까지 모두 탐색한 다음 빼줘야함

dfs()