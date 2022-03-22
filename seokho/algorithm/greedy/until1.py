import sys

input = sys.stdin.readline

# 1이 될 때까지 두 과정중 하나만 할 수 있다.
# N에서 1을 뺀다
# N을 K로 나눈다.(나누어 떨어질 때만 가능)

N, K = map(int, input().rstrip().split())
count = 0
while N != 1:
    if N % K == 0:  # 나누어 떨어진다면 나누자
        N = N//K
        count += 1
    else:
        N = N-1
        count += 1
print(count)
