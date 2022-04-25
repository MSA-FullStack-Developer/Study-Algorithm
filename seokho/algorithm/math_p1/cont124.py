def solution(n):
    answer = []
    a = ['1', '2', '4']
    while n > 0:
        n = n - 1
        temp = n % 3
        answer.append(a[temp])
        n = n // 3
    answer.reverse()
    answer = ''.join(answer)
    return answer
