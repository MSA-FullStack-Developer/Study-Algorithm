# 소수 찾기
# https://programmers.co.kr/learn/courses/30/lessons/42839
from itertools import permutations
import math
def isPrime(n):
    if n<2:
        return False
    for i in range(2, int(math.sqrt(n))+1): # n의 제곱근을 정수화 시켜준 후 + 1
        if n % i == 0:
            return False
    return True
def solution(numbers):
    answer=[]
    for k in range(1, len(numbers)+1):
        p_list = list(map(''.join, permutations(list(numbers), k)))
        for i in list(set(p_list)): # 중복제거
            if isPrime(int(i)):
                answer.append(int(i))

    answer = len(set(answer))

    return answer