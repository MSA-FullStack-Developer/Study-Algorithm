    
import sys
# sys.stdin=open("./in1.txt", "r")
n = int(input())
a=list(map(int, input().split()))
m = int(input())

for _ in range(m):
    i_max = a.index(max(a))
    i_min = a.index(min(a))
    a[i_max] -= 1
    a[i_min] += 1
res = max(a) - min(a)
print(res)



