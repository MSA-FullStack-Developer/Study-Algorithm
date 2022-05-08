# 백트래킹
# N 과 M (1)

N, M = map(int,input().split())

stack = []
def dfs():
    
    if len(stack) == M:
        print(' '.join(map(str,stack)))
        return

    for i in range(1, N+1):
        if i not in stack: 
            stack.append(i)
            dfs()
            stack.pop()
dfs()