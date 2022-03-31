    
import sys
# sys.stdin=open("./in1.txt", "r")
n, m=map(int, input().split())
a=list(map(int, input().split()))
a.sort()
cnt = 1
max_a = a.pop()
min_a = a.pop(0)
while len(a) > 1:
    if(min_a + max_a <= m):
        max_a = a.pop()
        min_a = a.pop(0)
    else:
        max_a = a.pop()
    cnt += 1
if a:
    cnt += 1
print(cnt)

#정렬하여 배열의 pop을 이용하여 푸는 문제
#마지막에 배에 한명이 남아있다면 보트의 갯수 증가시켜주는 것 잊지말것
