import sys

input = sys.stdin.readline

N = int(input())
#상근이가 가진 카드
N_list = list(map(int, input().rstrip().split()))
N_list.sort()
M = int(input())
#내가 맞출 카드번호 리스트
M_list = list(map(int, input().rstrip().split()))

def bin_search(arr, target, start, end):
    if start > end:
        return 0
    mid = (start + end) // 2
    if arr[mid] == target:
        return 1
    elif arr[mid] < target:
        return bin_search(arr, target, mid+1, end)
    else:
        return bin_search(arr, target, start, mid-1)

ans = []
for i in M_list:
    a = bin_search(N_list, i, 0, N-1)
    ans.append(a)

for i in ans:
    print(i, end=" ")