def solution(n):
    answer = ''
    a = ['4', '1', '2']
    while n :
        mod_n = n % 3
        answer = a[mod_n] + answer
        n = n // 3 - (n % 3 == 0)
    return answer
