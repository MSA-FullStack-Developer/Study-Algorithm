def solution(prices):
    answer = []
    count = 0
    j = 0
    while j != len(prices)-1:
        count = 0
        for i in range(j+1, len(prices)):
            if prices[j] <= prices[i]:
                count += 1
            else:
                count += 1
                break
        j += 1
        answer.append(count)
    answer.append(0)
    return answer
