# 수학
# 이항 계수 1

from itertools import combinations

N, K = map(int,input().split())

data = [i for i in range(N)]
combi = list(combinations(data,K)) # 이항 계수 -> 조합 수 


print(len(combi))
