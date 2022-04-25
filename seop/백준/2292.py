# 수학

N = int(input())

a = 6 #계차수열 공차6
minn = 2
maxx = 7
answer = 2

if N == 1:
    print(1)
else:
    while True:
        if minn <= N <= maxx:
            print(answer)
            break
        minn += a
        a += 6
        maxx += a
        answer += 1