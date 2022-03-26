    
import sys
# sys.stdin=open("./in1.txt", "r")
n, m=map(int, input().split())
a= list()
for _ in range(n):
    a.append(int(input()))
a.sort()
lt=a[0]
rt=a[n-1]
def Count(len):
    cnt = 1
    ep = a[0]
    for i in range(1, n):
        if a[i]-ep >= len:
            cnt+=1
            ep = a[i]
    return cnt


while lt <= rt:
    mid=(lt+rt)//2
    if Count(mid) >= m:
        res = mid
        lt = mid +1
    else:
        rt= mid - 1

print(res)

#결정 알고리즘 (이분탐색 ) 솔루션 전체 구조
#lt 와 rt를 구하고 그것에 대한 while문의 조건은 lt <= rt
#mid를 잡고 어느쪽을 날려버릴지 고민한다.

        


