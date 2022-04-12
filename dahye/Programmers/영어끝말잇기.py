def solution(n, words):
    answer = []
    who=0
    nth=0
    word_list=[words[0]]
    
    for i in range(1,len(words)):
        print(words[i])
        if words[i-1][-1] != words[i][0]:
            nth=int(i/n)+1
            who=int(i%n)+1
            break
        elif words[i] in word_list:
            nth=int(i/n)+1
            who=int(i%n)+1
            break
        else:
            word_list.append(words[i])
    
    answer=[who,nth]
    return answer
