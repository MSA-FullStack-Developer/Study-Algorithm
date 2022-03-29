import sys
import heapq

input = sys.stdin.readline

N = int(input())
classRoom = []
heap = []
for i in range(N):
    s, t = map(int, input().rstrip().split())
    classRoom.append([s, t])

# 수업 빨리 시작하는 순으로
classRoom = sorted(classRoom, key=lambda x: x[0])
heapq.heappush(heap, classRoom[0][1])  # 첫번째 수업 끝나는 시간을 넣는다.
for i in range(1, N):
    if heap[0] > classRoom[i][0]:
        heapq.heappush(heap, classRoom[i][1])
    else:
        heapq.heappop(heap)
        heapq.heappush(heap, classRoom[i][1])

print(len(heap))
