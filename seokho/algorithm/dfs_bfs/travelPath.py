import collections
answer = []
graph = collections.defaultdict(list)

tickets = [["ICN", "SFO"], ["ICN", "ATL"], [
    "SFO", "ATL"], ["ATL", "ICN"], ["ATL", "SFO"]]


# def dfs(s):
#     while graph[s]:
#         dfs(graph[s].pop(0))

#     if not graph[s]:
#         answer.append(s)
#         return


# def solution(tickets):

#     for a, b in tickets:
#         graph[a].append(b)
#     for a, b in graph.items():
#         graph[a].sort()

#     dfs("ICN")

#     return answer[::-1]


# print(solution(tickets))

def solution2(tickets):
    answer = []
    routes = collections.defaultdict(list)

    for a, b in tickets:
        routes[a].append(b)
    print(routes)
    for key in routes.keys():
        routes[key].sort()
    print(routes)
    stack = ['ICN']
    while stack:
        tmp = stack[-1]

        if not routes[tmp]:
            answer.append(stack.pop(0))
        else:
            stack.append(routes[tmp].pop(0))
    return answer


print(solution2(tickets))
