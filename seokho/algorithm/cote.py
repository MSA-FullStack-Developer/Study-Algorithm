import heapq

v = [4, 4, 3]
a = 2
b = 1

q = []


def solution(v, a, b):
    answer = 0
    for i in v:
        heapq.heappush(q, (-i, i))

    while True:
        temp = heapq.heappop(q)[1] - a

        if temp < 0:
            break

        flag = True
        for i in range(len(q)):
            x, rx = heapq.heappop(q)
            nx = rx-b
            if nx < 0:
                flag = False
                break

            heapq.heappush(q, (-nx, nx))

        if flag == False:
            break
        heapq.heappush(q, (-temp, temp))
        answer += 1
    return answer


print(solution(v, a, b))
