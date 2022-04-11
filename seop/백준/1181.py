n = int(input())
data = []
for i in range(n):
    data.append(input())

# -----------------입력받기------------------

data = list(set(data)) # 중복 제거
data.sort(key = lambda x: (len(x), x)) #길이순으로 정렬하고(우선), 사전순으로 정렬

for i in data:
    print(i)