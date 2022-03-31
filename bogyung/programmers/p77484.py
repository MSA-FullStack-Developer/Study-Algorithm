# 로또의 최고 순위와 최저 순위
# https://programmers.co.kr/learn/courses/30/lessons/77484
def solution(lottos, win_nums):
    dic={'0':6, '1':6, '2':5,'3':4, '4':3, '5':2,'6':1}
    answer = []
    min_win = 0
    zero = 0
    for i in lottos:
        if i == 0:
            zero += 1
        if i in win_nums:
            min_win += 1

    answer.append(dic[str(min_win + zero)])
    answer.append(dic[str(min_win)])
    return answer