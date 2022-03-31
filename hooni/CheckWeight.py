    
import sys
# sys.stdin=open("./in1.txt", "r")
n = int(input())
a= list()
for _ in range(n):
    n, m=map(int, input().split())
    a.append((n, m))

a.sort(reverse=True)
weight_max = 0
cnt = 0
for height, weight in a:
    if weight > weight_max:
        weight_max = weight
        cnt+=1
print(cnt)




# 정렬한 후 최대 몸무게를 잡고 다음 배열의 몸무게를 가져와 큰지를 비교하고 넘긴다.
# 다음 배열의 몸무게가 크다고 하면 cnt 를 증가시키고 최대 몸무게를 바꿔준다.

