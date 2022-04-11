#완전탐색

n, m = map(int, input().split());

data = {i: [] for i in range(1, n+1)}
for i in range(m):
    a,b = map(int, input().split());
    data[a].append(b)

count = 0
for i in range(1,n-1):
    for j in range(i+1,n):
        if j in data[i]:
            continue
        for k in range(j+1,n+1):
            if k in data[i] or k in data[j] or j in data[k]:
                continue
            
            count += 1

print(count)