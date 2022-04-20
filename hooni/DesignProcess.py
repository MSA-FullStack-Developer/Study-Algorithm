
from collections import deque
import sys
# sys.stdin=open("./in2.txt", "r")
essential_class = input()
a = int(input())
for i in range(1, a + 1):
    plan_class = input()
    check_ec = deque(essential_class[:])
    for k in plan_class:
        if k in check_ec:
            if(k != check_ec.popleft()):
                print("#%d NO" %i)
                break
    else:
        if check_ec:
            print("#%d NO" %i)
        else:
            print("#%d YES" %i)



#for-else 구문
# 항상 글로만 봤지만 사용해 본적은 처음이다.
# for 문 안에서 break로 나오면 else로 안들어감.
# for 문을 정상적으로 나왔을때 들어감.
