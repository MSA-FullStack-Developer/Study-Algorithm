import sys

input = sys.stdin.readline

N = int(input())

prod = []
for i in range(N):
    prod.append(int(input()))

# 비싼 순으로 정렬
prod.sort(reverse=True)

# 3개씩 묶기
a = sum(prod)
b = 0
for i in range(len(prod)):
    if (i+1) % 3 == 0:
        b += prod[i]

print(a-b)
