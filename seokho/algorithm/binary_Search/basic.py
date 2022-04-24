# 이진 탐색 재귀
def bin_rec(arr, target, start, end):
    if start > end:
        return None
    # mid는 타겟의 위치
    mid = (start + end) // 2
    if arr[mid] == target:
        return mid
    # 중간점 값보다 찾고자 하는 값이 작은 경우
    elif arr[mid] > target:
        return bin_rec(arr, target, start, mid-1)
    # 중간점 값보다 찾고자 하는 값이 큰 경우
    else:
        return bin_rec(arr, target, mid+1, end)


# 이진 탐색 반복문
def bin_for(arr, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if arr[mid] == target:
            return mid
        # 중간점의 값보다 찾고자 하는 값이 작은 경우
        elif arr[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return None


n, target = list(map(int, input().split()))
arr = list(map(int, input().split()))

# result = bin_rec(arr, target, 0, n-1)
# if result == None:
#     print("원소가 존재하지 않음")
# else:
#     print(result + 1)

result = bin_for(arr, target, 0, n-1)
if result == None:
    print("원소가 존재하지 않음")
else:
    print(result + 1)
