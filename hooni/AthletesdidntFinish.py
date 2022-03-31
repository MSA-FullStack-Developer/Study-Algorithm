def solution(participant, completion):
    part = dict()
    for i in participant:
        part[i] = part.get(i, 0) + 1
    for i in completion:
        part[i] = part[i] - 1
    for key, value in part.items():
        if(value > 0):
            return key



#카운터를 이용한 풀이

import collections


def solution(participant, completion):
    answer = collections.Counter(participant) - collections.Counter(completion)
    return list(answer.keys())[0]
