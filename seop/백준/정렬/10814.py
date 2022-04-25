# 정렬
# 나이순 정렬
N = int(input())

data = []
for _ in range(N):
    data.append(list(map(str,input().split())))

data.sort(key = lambda x: int(x[0])) # int(x[0])기준으로 정렬

for d in data:
    print(int(d[0]), d[1])