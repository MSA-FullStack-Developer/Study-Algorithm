def solution(progresses, speeds):
    answer = []
    cnt = 0
    while(progresses):
        for i in range(len(progresses)):
            progresses[i] = progresses[i] + speeds[i]
        while(progresses and progresses[0] >= 100):
            progresses.pop(0)
            speeds.pop(0)
            cnt += 1
        if(cnt > 0) :
            answer.append(cnt)
        cnt = 0
        
    return answer

#while문 안의 while 문안에 조건을 progresses가 null인지 조건을 넣어주지않는다면
#list index 가벗어나는 에러가 난다. 저 조건을 생각하기까지 많은 생각을 했다.

#list 끼리의 덧셈은 이렇게도 표현 가능
#progresses = [progresses[i] + speeds[i] for i in range(len(progresses))]
