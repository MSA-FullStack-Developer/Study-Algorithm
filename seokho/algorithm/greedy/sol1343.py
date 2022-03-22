import sys

input = sys.stdin.readline

# 2, 4, 6, 8
p1 = "AAAA"
p2 = "BB"

board = input().rstrip().split('.')

flag = True
while(flag):
    for i in range(len(board)):
        # 4의 배수이면 무조건 AAAA 부터
        if len(board[i]) == 4:
            board[i] = p1
            continue
        elif len(board[i]) == 2:
            board[i] = p2
            continue
        elif len(board[i]) % 2 == 1:
            flag = False
            break
        elif len(board[i]) > 4:
            if len(board[i]) % 4 == 0:
                n = len(board[i])//4
                board[i] = p1*n
                continue
            else:
                n = len(board[i])//4
                board[i] = p1*n + p2
                continue
    break
answer = ""
if flag:
    print(".".join(board))
else:
    print(-1)
