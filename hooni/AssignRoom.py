    
import sys
# sys.stdin=open("./in1.txt", "r")
n = int(input())
a= list()
for _ in range(n):
    n, m=map(int, input().split())
    a.append((n, m))

a.sort(key=lambda a: a[1])

et = a[0][1]
cnt = 1            
for x, y in a:
    if x >= et:
        et = y
        cnt += 1

print(cnt)

#그리디 알고리즘은 거의 대부분 정렬 문제이다.
#기준을 잘 잡아보자.
#sort key 주는 법
# -> lambda 를 사용하여 준다
