# Brute-Foce
# 체스판 다시 칠하기

N, M = map(int,input().split())

data = []

for _ in range(N):
    data.append(list(map(str,input())))

def scan(i,j):
    W = 0 # W로 시작할 경우 바꿔야할 개수
    B = 0 # B로 시작할 경우 바꿔야할 개수
    for a in range(i,i+8):
        for b in range(j,j+8):
            if (a+b) % 2 == 0: # 짝수 칸인 경우
                if data[a][b] != 'W': # 짝수칸이 W가 아니라면
                    W += 1 
                if data[a][b] != 'B': # 짝수칸이 B가 아니라면
                    B += 1
            else: # 홀수칸일 경우
                if data[a][b] != 'B': # 홀수칸이 B가 아니라면
                    W += 1
                if data[a][b] != 'W':
                    B += 1
    return min(W,B)

answer = 32 # 제일 많이 칠해야하는 경우
for i in range(N-7): # 8넘어가면 안되므로 7빼줌
    for j in range(M-7):
            answer = min(answer,scan(i,j))

print(answer)