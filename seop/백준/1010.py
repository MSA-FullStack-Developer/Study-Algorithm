# DP
n = int(input())
dp = [0,0,0]
dp[0] = 'SK'
dp[1] = 'CY'
dp[2] = 'SK'

for i in range(3,n):
    dp.append(dp[i-2])

print(dp[n-1])

#이렇게해도 되는데 그냥 위에처럼 해봤음..

# n = int(input())
# if n % 2 == 0:
#     print('CY')
# else:
#     print('SK')