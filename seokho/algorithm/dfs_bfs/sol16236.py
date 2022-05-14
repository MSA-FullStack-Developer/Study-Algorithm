import sys

input = sys.stdin.readline

N = int(input())

graph = []
for i in range(N):
    graph.append(list(map(int, input().split())))

print(graph)
