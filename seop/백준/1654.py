#이분 탐색

K, N = map(int, input().split()) # 4 11

data = [int(input()) for _ in range(K)] # 802 743 457 539

min = 1
max = max(data)
answer = 0

while min<=max:

    count = 0
    mid = (min + max) // 2

    for d in data:
        count += (d // mid)
    
    if count < N: # 자른 랜선 수가 부족할 경우
        max = mid - 1
    else: # 자른 랜선의 수가 더 많을 경우
        answer = mid
        min = mid + 1

print(answer)