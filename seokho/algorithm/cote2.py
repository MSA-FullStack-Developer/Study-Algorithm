

logs = ["0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80",
        "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"]

graph = [[] * 4 for _ in range(12)]


def solution(logs):
    for i in logs:
        SID, PNO, SCORE = map(int, i.split())
        graph[SID].append((PNO, SCORE))


solution(logs)

print(graph)
