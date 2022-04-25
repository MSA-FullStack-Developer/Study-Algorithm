# 정렬
# 좌표 정렬하기
N = int(input())

data = []
for _ in range(N):
    data.append(list(map(int,input().split())))

data.sort(key = lambda x : (x[0], x[1])) # x[0] 기준으로 정렬하고(먼저), x[1]로 정렬함. 

for d in data:
    print(d[0], d[1])