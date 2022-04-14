def solution(s):
    numbers=["zero","one","two","three","four","five","six","seven","eight","nine"]    
    number_str=""
    start=0
    
    for i in range(len(s)):
        temp=s[start:i+1]
        
        if len(temp)==1:
            if ord(temp)>47 and ord(temp)<58:
                number_str+=temp
                start=i+1
        else:
            if temp in numbers:
                number_str+=str(numbers.index(temp))
                start=i+1
                
    answer=int(number_str)
    
    return answer
