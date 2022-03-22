import sys

input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
card = []
for i in range(N):
    card.append(list(map(int, input().rstrip().split())))

answer = []
for i in range(len(card)):
    answer.append(min(card[i]))

print(max(answer))
