# 수학
# 직사각형에서 탈출

x,y,w,h = map(int,input().split())

w = min(w-x, x)
h = min(h-y, y)
print(min(w,h))