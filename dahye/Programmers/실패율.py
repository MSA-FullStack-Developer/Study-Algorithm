def solution(N, stages):
    answer=[]
    rates={}
    
    for stage in range(1,N+1):
        mo=0
        ja=0
        for s in stages:
            if s>=stage:
                mo+=1
            if s==stage:
                ja+=1
        if mo==0:
            rates[stage]=0
        else:
            rates[stage]=ja/mo
        
    sorted_rates = sorted(rates.items(), key = lambda item: item[1] ,reverse = True)
    
    for rate in sorted_rates:
        answer.append(rate[0])
    
    return answer
