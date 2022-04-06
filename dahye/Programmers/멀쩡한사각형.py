import math

def solution(w,h):
    
    cut=0
    
    if w>h:
        temp=w
        w=h
        h=temp
    
    # 가장 작은 단위로 쪼개기 위한 최대공약수
    g=math.gcd(w,h)
    # 가장 작은 단위의 개수
    cut=g*(2*(w/g-1)+h/g-(w/g-1))

    answer=w*h-cut
    return answer
