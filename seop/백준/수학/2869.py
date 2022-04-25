# 수학
# 달팽이는 올라가고 싶다
import math

A, B, V = map(int,input().split())

day =  math.ceil((V-A) / (A-B)) +1  # 하루에 A-B만큼 올라가니까 V에서 나눠주면 일수가 나오는데 이미 도착하면 안내려와도 되니까
                            # 낮에 올라가는만큼은 빼줘야함. 그다음날 도착할거니까 1더해주면됨.
print(day)