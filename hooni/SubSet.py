import sys

def DFS(L, sum_):
    if sum_ > total:
        return
    else:
        if(sum == (total - sum)):
            print("YES")
            sys.exit(0)
        else:
            DFS(L+1, sum + a[L+1])
            DFS(L+1, sum + a[L])
    return 

if __name__=="__main__":
    n=int(input())
    a=list(map(int, input().split()))
    total = sum(a)
    DFS(0,0)
    print("NO")

