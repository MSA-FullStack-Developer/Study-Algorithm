import sys

input = sys.stdin.readline
n = int(input().rstrip())
n_list = list(map(int, input().rstrip().split()))

# 정렬된 가게의 부품
n_list.sort()

m = int(input().rstrip())
m_list = list(map(int, input().rstrip().split()))


def bin_search(arr, target, start, end):
    mid = (start + end) // 2
    if start > end:
        return None
    elif arr[mid] == target:
        return mid
    elif arr[mid] > target:
        return bin_search(arr, target, start, mid-1)
    else:
        return bin_search(arr, target, mid + 1, end)


for i in m_list:
    if bin_search(n_list, i, 0, n-1) != None:
        print("yes")
    else:
        print("no")
