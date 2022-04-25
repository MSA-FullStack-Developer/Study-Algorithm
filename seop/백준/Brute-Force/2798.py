# Brute-Force
# 블랙잭
N, M = map(int, input().split())
data = list(map(int,input().split()))

answer = 0

for i in range(N):
    for j in range(i+1, N):
        for k in range(j+1, N):
            if (data[i]+data[j]+data[k]) <= M:
                answer = max(answer, data[i]+data[j]+data[k]) # M보다 작으면서 최댓값

print(answer)