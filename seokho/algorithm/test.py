import sys
sys.setrecursionlimit(10**7)


def solution(n, costs):
    answer = 0
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

    for i in costs:
        a, b, c = i
        edges.append((c, a, b))

    edges.sort()
    parent = [i for i in range(n)]

    for i in edges:
        c, a, b = i
        if findParent(a) != findParent(b):
            union(a, b)
            answer += c

    return answer


n = 4
cost = [[0, 1, 1], [0, 2, 2], [1, 2, 5], [1, 3, 1], [2, 3, 8]]
print(solution(4, cost))
