# 2022 KAKAO BLIND RECRUITMENT
# https://programmers.co.kr/learn/courses/30/lessons/92334
# 신고 결과 받기

def solution(id_list, report, k):

    # split()으로 리스트 -> 튜플 -> set -> 리스트
    report = set(list(map(tuple,map(lambda x: x.split(" "), report))))

    # 유저 : 신고당한 횟수. (딕셔너리)
    reported = {id : 0 for id in id_list}
    # 유저 : 신고한 ID. (딕셔너리)
    reporter = {id : [] for id in id_list}

    # 유저별 신고당한 횟수를 넣어줌.
    for re in report:
        reported[re[1]] = reported[re[1]] + 1

    # 유저가 신고한 유저를 넣어줌. 근데 ( 신고당한 횟수 >= K )인 녀석들만 넣어줄거임.
    for re in report:
        if reported[re[1]] >= k:
            reporter[re[0]].append(reported[re[0]])

    # 유저가 신고한 애들 중 메시지를 받은 애들의 수
    answer = [len(reporter[re]) for re in reporter]

    return answer