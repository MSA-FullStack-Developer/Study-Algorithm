#DFS

def solution(n):
    answer=DFS(n)
    return answer
    
def DFS(n):
    if n == 1:
        return "1"
    elif n==2:
        return "2"
    elif n==0 or n==3:
        return "4"
    else:
        if n%3==0:
            return DFS(int(n/3)-1)+DFS(n%3)
        else:
            return DFS(int(n/3))+DFS(n%3)
