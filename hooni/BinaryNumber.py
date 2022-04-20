import sys
sys.stdin=open("./in1.txt", "r")
def DFS(x):
    if x==0:
        return
    else:
        DFS(x//2)
        print(x%2, end='')

n=int(input())
DFS(n)

