import sys

input = sys.stdin.readline

V, E = map(int, input().split())

parent = [i for i in range(V+1)]

edges = []

def findParent(parent, x):
    if parent[x] != x:
        parent[x] = findParent(parent, parent[x])
    return parent[x]

def union(parent, x, y):
    a = findParent(parent, x)
    b = findParent(parent, y)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

for _ in range(E):
    a, b, c = map(int, input().split())
    edges.append((c, a, b))

edges.sort()
result = 0
for i in edges:
    c, a, b = i
    # 사이클이 생기지 않는 경우만 집합에 포함하고 길이를 추가한다.
    if findParent(parent, a) != findParent(parent, b):
        union(parent, a, b)
        result += c

print(result)