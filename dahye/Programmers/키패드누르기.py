def solution(numbers, hand):
    answer = ''
    handL=[3,0]
    handR=[3,2]
    
    for number in numbers:

        #눌러야하는 키패드 위치
        if number==0:
            loc=[3,1]
        else:
            loc=[int((number-1)/3),(number-1)%3]        
        
        #누르기
        if number== 1 or number==4 or number==7:
            handL=[loc[0],0]
            answer+='L'
        elif number== 3 or number==6 or number==9:
            handR=[loc[0],2]
            answer+='R'
        else:
            farL=abs(handL[0]-loc[0])+abs(handL[1]-loc[1])
            farR=abs(handR[0]-loc[0])+abs(handR[1]-loc[1])
            
            if farL<farR:
                handL=[loc[0],1]
                answer+='L'
            elif farR<farL:
                handR=[loc[0],1]
                answer+='R'
            else:
                if hand=="right":
                    handR=[loc[0],1]
                    answer+='R'
                else:
                    handL=[loc[0],1]
                    answer+='L'        

    return answer
