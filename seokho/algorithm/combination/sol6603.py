import sys
from itertools import combinations

input = sys.stdin.readline
K = 0
S = []
while True:
    temp = list(map(int, input().split()))
    K = temp[0]
    if K == 0:
        break
    S = temp[1:]
    answer = list(combinations(S, 6))
    for i in answer:
        for j in i:
            print(j, end=" ")
        print()
    print()