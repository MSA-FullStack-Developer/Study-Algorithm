# 문자열

while True:
    N = str(input())
    
    if N == '0':
        break
    
    if ''.join(reversed(N)) == N: # 문자열을 뒤집기
        print('yes')
    else:
        print('no')