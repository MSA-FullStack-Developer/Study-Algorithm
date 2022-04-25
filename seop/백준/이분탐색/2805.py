# 이분탐색
# 나무 자르기

n, m = map(int, input().split())
data = list(map(int, input().split()))

min = 0
max = max(data)
answer = 0
while min <= max:
    mid = ( min + max ) // 2
    sum = 0

    for d in data:
        if d >= mid: # 절단기 높이가 나무 높이보다 낮아야 나무가 잘림
            sum += (d-mid)
            if sum > m: # 필요한거보다 많이 잘랐으면
                break

    if sum < m: # 왼쪽부분 탐색
        max = mid - 1
    else: # 오른쪽 부분 탐색
        answer = mid # 최대한 덜 잘랐을 때가 정답이니까
        min = mid + 1
print(answer)