T = int(input())

for i in range(T):
    K = int(input()) # 층수
    N = int(input()) # 호수

    data = [[i for i in range(1,N+1)] for _ in range(K+1)] # 초기화

    for i in range(1,K+1):
        for j in range(N):
            data[i][j] = sum([data[i-1][k] for k in range(N) if k<=j]) # 이건 좀 이상해서 한번 손봐야할것 같긴함..

    
    print(data[K][N-1])