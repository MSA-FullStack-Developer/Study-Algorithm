# 신고 결과 받기
# https://programmers.co.kr/learn/courses/30/lessons/92334
from collections import defaultdict


def solution(id_list, report, k):
    answer = [0] * len(id_list)  # id_list 길이만큼 초기화
    report = set(report)  # 중복제거

    i_reported = defaultdict(set)  # 신고한 유저 목록
    num_report = defaultdict(int)  # 신고당한 횟수
    suspended = []  # k번이상 신고당한 유저 리스트

    for r in report:
        pair = r.split(' ')  # pair[0]: 신고자, pair[1]: 신고당한 자
        num_report[pair[1]] += 1
        i_reported[pair[0]].add(pair[1])

        if num_report[pair[1]] == k:
            suspended.append(pair[1])
    for s in suspended:  # 신고 k번 이상 넘은 리스트
        for i in range(len(id_list)):  # 전체 id 리스트
            if s in i_reported[id_list[i]]:
                answer[i] += 1

    return answer