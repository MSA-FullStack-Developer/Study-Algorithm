from math import fabs


N, M = map(int, input().split())

rs = []
check = [False] * (N+1)


def bt(depth):
    if depth == M:
        print(' '.join(map(str, rs)))
        return
    for i in range(1, N+1):
        if check[i] == False:
            check[i] = True
            rs.append(i)
            bt(depth+1)
            check[i] = False
            rs.pop()


bt(0)
