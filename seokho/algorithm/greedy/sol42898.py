def solution(m, n, puddles):
    count = 0
    # 아래, 우
    mx = [0, 1]
    my = [1, 0]
    ans = []
    cango = [[1]*m for i in range(n)]
    # 웅덩이가 있는 곳 찾기
    for a, b in puddles:
        cango[b-1][a-1] = 0

    stack = [(0, 0, 0)]
    while stack:
        x, y, c = stack.pop()
        if x == m-1 and y == n-1:
            # ans.append(c)
            count += 1
        for i in range(2):  # 아래, 오른쪽 갈 수 있는 곳 탐색
            nx = x+mx[i]
            ny = y+my[i]
            if(0 <= nx < m and 0 <= ny < n):
                if(cango[ny][nx] == 1):
                    stack.append((nx, ny, c+1))
    return count % 1000000007


def solution1(m, n, puddles):
    ans = [[0]*(m+1) for i in range(n+1)]
    print(ans)
    ans[1][1] = 1     # 출발점

    for i in range(1, n+1):
        for j in range(1, m+1):
            if i == 1 and j == 1:  # 출발점은 건너띄기
                continue
            if [j, i] in puddles:  # 물웅덩이
                ans[i][j] = 0
            else:
                # 위와 왼쪽 값 더하기
                ans[i][j] = ans[i-1][j]+ans[i][j-1]
    return ans[n][m] % 1000000007

m = 4
n = 4
puddles = [[3, 2], [2, 4]]

print(solution1(m, n, puddles))
