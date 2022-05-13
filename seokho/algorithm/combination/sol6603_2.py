import sys

input = sys.stdin.readline


def dfs(start, depth):
    if depth == 6:
        for i in range(6):
            print(answer[i], end=' ')
        print()
        return
    for i in range(start, len(S)):
        answer[depth] = S[i]
        dfs(i+1, depth+1)

answer = [0 for _ in range(6)]

while True:
    temp = list(map(int, input().split()))
    K = temp[0]
    if K == 0:
        break
    S = temp[1:]
    dfs(0,0)

