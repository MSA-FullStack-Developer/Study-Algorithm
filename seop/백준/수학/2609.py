# 수학
# 최대공약수와 최소공배수
from re import A

A, B = map(int,input().split())
if A < B:
    temp = A
    A = B
    B = temp

def gcd(a,b): #최대 공약수
    if b == 0: # b가 0이면 a 리턴
        return a
    
    if a % b == 0: # a가 b로 나눠 떨어지면 b 리턴
        return b
    else: # a가 b로 나눠 떨어지지 않으면 a = b, b = a % b 하고 다시 gcd를 구함
        return gcd(b, a % b)

gcdd = gcd(A,B)
print(gcdd)
# 최소공배수 = 두 자연수의 곱 / 최대공약수
print(A*B // gcdd)