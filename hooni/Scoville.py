def solution(scoville, K):
    import heapq
    heapq.heapify(scoville)
    answer = 0
    while len(scoville) >= 2:
        min1=heapq.heappop(scoville)
        if (min1 >= K):
            print(min1)
            return answer
        else:
            min2=heapq.heappop(scoville)
            heapq.heappush(scoville, min1 + min2*2)
            answer += 1
            
    if heapq.heappop(scoville) > K:
        return answer
    else:
        return -1

