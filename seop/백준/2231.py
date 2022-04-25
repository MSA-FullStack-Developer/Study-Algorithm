#Brute-Force

N = int(input())

for i in range(1,N+1):

    data = i+sum(map(int,str(i)))

    if data == N: #해당 숫자의 생성자가 분해합(N)과 같다면
        print(i)
        break
    if i == N: # 생성자가 없는 경우
        print(0)