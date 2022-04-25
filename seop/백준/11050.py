# 수학
# 이항계수 -> 조합 개수 

from itertools import combinations

N, K = map(int,input().split())

data = [i for i in range(N)]
combi = list(combinations(data,K))

print(len(combi))
