# 수학
x,y,w,h = map(int,input().split())

w = min(w-x, x)
h = min(h-y, y)
print(min(w,h))