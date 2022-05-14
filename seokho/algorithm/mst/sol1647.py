import sys

input = sys.stdin.readline

N, M = map(int, input().split())

parent = [i for i in range(N+1)]

edges = []

def findParent(x):
    if parent[x] != x:
        parent[x] = findParent(parent[x])
    return parent[x]

def union(a, b):
    a = findParent(a)
    b = findParent(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

for i in range(M):
    a, b, c = map(int, input().split())
    edges.append((c, a, b))

edges.sort()

result = 0
ans = []
for i in edges:
    c, a, b = i
    if findParent(a) != findParent(b):
        union(a, b)
        ans.append(c)
        result += c

print(result- max(ans))