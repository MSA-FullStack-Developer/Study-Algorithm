import sys

input = sys.stdin.readline

n = int(input().rstrip())
rope = []
for i in range(n):
    rope.append(int(input().rstrip()))

rope.sort(reverse=True)
answer = rope[0]
for i in range(1, len(rope)):
    if answer < rope[i]*(i+1):
        answer = rope[i]*(i+1)
print(answer)
