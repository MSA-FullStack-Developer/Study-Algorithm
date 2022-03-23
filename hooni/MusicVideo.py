    
import sys
sys.stdin=open("./in2.txt", "r")
def Count(a, capacity):
    cnt=1
    sum=0
    for x in a:
        if sum+x>capacity:
            cnt+=1
            sum = x
        else:
            sum+=x
    return cnt

n, m=map(int, input().split())
a=list(map(int, input().split()))
maxx=max(a)
lt=1
rt=sum(a)
res=0
while lt<=rt:
    mid=(lt+rt)//2
    if mid>=maxx and Count(a, mid)<=m:
        res=mid
        rt=mid-1
    else:
        lt=mid+1
print(res)

#결정 알고리즘 : lt rt mid의 연관성과 조건 분기문을 어떻게 처리할지 생각할것
        

