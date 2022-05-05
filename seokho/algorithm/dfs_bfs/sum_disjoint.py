import sys


def dfs(L, sum):
    # 부분집합의 합이 전체의 절반보다 큰 경우 더 볼 필요 없음
    if sum > (total // 2):
        return
    if L == n:
        if sum == (total - sum):
            print("YES")
            sys.exit(0)
    else:
        dfs(L+1, sum + a[L])
        dfs(L+1, sum)


if __name__ == "__main__":
    n = int(input())
    a = list(map(int, input().split()))
    total = sum(a)
    dfs(0, 0)
    print("no")
