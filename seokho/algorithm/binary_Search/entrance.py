def solution(n, times):
    answer = 0
    times.sort()

    start = 0
    end = times[-1] * n
    while start <= end:
        mid = (start + end) // 2
        count = 0
        # 현재 시점에서 입국 완료한 인원 수
        for i in times:
            count += mid // i
            if count >= n:
                break
        if count >= n:
            answer = mid
            end = mid-1
        else:
            start = mid + 1
    return answer
