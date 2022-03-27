import heapq


def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    while scoville[0] < K:
        # 모든 스코빌 지수를 K이상으로 만들 수 없는 경우
        if len(scoville) == 1:
            answer = -1
            break
        m1 = heapq.heappop(scoville)
        m2 = heapq.heappop(scoville)
        ns = m1 + (m2*2)
        heapq.heappush(scoville, ns)
        answer += 1
    return answer
