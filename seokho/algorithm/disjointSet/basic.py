# 부모 노드 찾는 함수
def find_parent(parent, x):
    # 루트노트가 아니라면 찾을 때까지 재귀
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


# 노드의 갯수와 간선의 갯수 입력 받기
v, e = map(int, input().split())
parent = [0] * (v+1)

for i in range(1, v+1):
    parent[i] = i

for i in range(e):
    a, b = map(int, input().split())
    union_parent(parent, a, b)

for i in range(1, v+1):
    print(find_parent(parent, i), end=' ')
