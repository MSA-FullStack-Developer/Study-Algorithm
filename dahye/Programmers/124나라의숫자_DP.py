#DP

def solution(n):
    answer = ''
  
    DP=["0","1","2","4"]
  
    for i in range(4,n+1):
        if i%3==0:
            DP.append(DP[int(i/3)-1]+'4')
        else:
            DP.append(DP[int(i/3)]+DP[i%3])
            
    answer=DP[n]
   
    return answer
