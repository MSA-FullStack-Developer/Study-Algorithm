def solution(id_list, report, k):
    answer = []
    # 신고한사람 아이디 담기
    id_list = {i: [] for i in id_list}
    # 받을 메일 수 담기
    answer_list = {i: 0 for i in id_list}
    for i in report:
        a, b = i.split(" ")
        for j in id_list.keys():
            if b == j:
                if a not in id_list[j]:
                    id_list[j].append(a)
    ban = []
    for i in id_list.keys():
        # 정지 시킬 아이디
        if (len(id_list[i]) >= k):
            ban.append(i)
    for i in ban:
        for j in id_list[i]:
            answer_list[j] += 1
    answer = list(answer_list.values())
    print(answer)
    return answer
