def solution(w, h):
    # 직선의 방정식으로 갯수 구하기
    # 기울기
    answer = 0
    sum = 0
    m = (h-0)/(0-w)
    if w == 1 or h == 1:
        return 0
    if w == h:
        return w*h - w

    for i in range(1, w):
        m = (h-0)/(0-w)
        exp = int(m*i + h)
        sum += exp

    answer = sum*2

    return answer
