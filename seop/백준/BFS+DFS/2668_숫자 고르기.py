# DFS
# 숫자고르기

N = int(int(input()))

data = []
for _ in range(N):
    data.append(int(input()))

visited = []
stack = set()

def dfs(a,x):
    global stack
    
    if a == x:
        visited.append(a)
        return True
    
    if x in stack:
        stack.clear()
        return False

    stack.add(x)
    dfs(a,data[x-1]) 
    stack.clear()

for i in range(N):
    a = i+1 # 첫줄 번호
    dfs(a,data[i]) # data[i]는 첫줄 바로 아래 번호

print(len(visited))
for v in visited:
    print(v)