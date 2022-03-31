# 비밀지도
# https://programmers.co.kr/learn/courses/30/lessons/17681
def solution(n, arr1, arr2):
    answer = []
    for i in range(n):
        arr1[i] = format(arr1[i], 'b').zfill(n)  # 이진수로 변경
        arr2[i] = format(arr2[i], 'b').zfill(n)

    for i in range(n):
        tmp = ''
        for j in range(n):
            if '1' in (arr1[i][j], arr2[i][j]):
                tmp += '#'
            else:
                tmp += ' '
        answer.append(tmp)
    return answer