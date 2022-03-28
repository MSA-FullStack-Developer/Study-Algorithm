# https://programmers.co.kr/learn/courses/30/lessons/84512
# 모음 사전
from itertools import product

def solution(word):
    d_list=[]
    alpha = ['A','E','I','O','U']

    for i in range(1, 6):
        d_list+=list(map(''.join, product(alpha, repeat=i))) # i개수 만큼 카티션프로덕트
    d_list.sort() # 전체 정렬
    answer=d_list.index(word)+1 # 몇번째인지

    return answer

