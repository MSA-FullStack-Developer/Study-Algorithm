import sys
import heapq

input = sys.stdin.readline

heap = []

N = int(input())

for i in range(N):
    a = int(input())
    if a == 0:
        # 힙이 있으면 빼고
        if heap:
            print(-heapq.heappop(heap))
        # 없으면 그냥 0 출력
        else:
            print(0)
    else:
        heapq.heappush(heap, -a)
