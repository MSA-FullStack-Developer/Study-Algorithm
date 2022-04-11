n = int(input())
data = []
for i in range(n):
    data.append(input())

# -----------------입력받기------------------

for word in data:
    # 한글자 이상의 단어만 검사
    if len(word) > 1:
        for i in range(len(word)-1): 
            # 다음 문자가 현재문자와 다르고, 지금까지 나온적이 있다면 false
            if word[i+1] != word[i] and word[i+1] in word[0:i]:
                n -= 1
                break
print(n)
