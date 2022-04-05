# 체육복
# https://programmers.co.kr/learn/courses/30/lessons/42862
def solution(n, lost, reserve):
    # 여벌의 체육복이 있는 학생도 도난당할 수 있음
    set_reserve=set(reserve)-set(lost)
    set_lost=set(lost)-set(reserve)
    # 왼쪽부터 탐색
    for i in set_reserve:
        if i-1 in set_lost:
            set_lost.remove(i-1)
        elif i+1 in set_lost:
            set_lost.remove(i+1)
    return n-len(set_lost)