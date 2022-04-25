# 수학
# 직각삼각형
while True:
    a,b,c = map(int,input().split())

    if a == 0 and b == 0 and c == 0:
        break
    
    t = sorted([a,b,c]) # 빗변이 제일 큰놈이기 때문에 정렬 해줘야함.
    
    
    if ((t[0]**2) + (t[1]**2)) == t[2]**2 :
        print('right')
    else:
        print('wrong')
