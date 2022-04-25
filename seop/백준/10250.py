# 구현

K = int(input())

for _ in range(K):
    H, W, N  = map(int, input().split()) # 층수, 각 층 방수, 손님번호

    XX = 0 # 층수
    YY = 1 # 방번호

    for _ in range(N):
        XX += 1
        if XX > H: # 최대 층수보다 넘어가면
            YY +=1 # 방번호 추가해주고
            XX = 1 # 1층으로 내림
    
    XX = str(XX)
    YY = str(YY).zfill(2) # 왼쪽에 0을 채워줌 (길이만큼)
    
    print(int(''.join([XX,YY])))

