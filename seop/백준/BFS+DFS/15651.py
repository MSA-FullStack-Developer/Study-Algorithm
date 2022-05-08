# 백트래킹
# N 과 M (3)

N, M = map(int,input().split()) # N까지 M개


stack = []
def dfs():
    
    if len(stack) == M: # #스택의 길이가 M이라면
        print(' '.join(map(str, stack)))
        return

    for i in range(1,N+1):
        stack.append(i)
        dfs()
        stack.pop()
dfs()