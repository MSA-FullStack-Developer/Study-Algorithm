# 정렬
# 수 정렬하기 2
import sys
N = int(sys.stdin.readline()) #sys.stdin.readline() 안쓰면 시간초과남..

data = []
for _ in range(N):
    data.append(int(sys.stdin.readline()))
data.sort()

for d in data:
    print(d)