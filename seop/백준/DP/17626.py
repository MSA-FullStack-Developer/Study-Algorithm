import math

N = int(input())

d = [0] * (N+1)
d[0] = 0
d[1] = 1
for i in range(2,N+1):
    
    c = []
    for j in range(1, int(math.sqrt(i))+1): # i의 제곱근 까지 반복
        c.append(1+d[i-j**2])
    d[i] = min(c)

print(d[N])