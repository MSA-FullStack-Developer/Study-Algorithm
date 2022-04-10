# 선택 정렬 (매번 가장 작은 것은 선택한다.)
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]
for i in range(len(array)):
    min_index = i  # 가장 작은 원소의 인덱스
    for j in range(i + 1, len(array)):
        if array[min_index] > array[j]:
            min_index = j
        array[i], array[min_index] = array[min_index], array[i]

print("선택정렬 : ", array)
# 선택정렬 시간 복잡도 O(N^2)

# 삽입정렬 (데이터를 확인하며 적절한 위치에 넣는다.) 리스트가 거의 정렬된 상태면 매우빠르게 동작
# 삽입정렬의 시간복잡도 O(N^2)
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]
for i in range(1, len(array)):
    for j in range(i, 0, -1):
        if array[j] < array[j-1]:
            array[j], array[j-1] = array[j-1], array[j]
        else:
            break

print(array)

# 퀵 정렬(가장 많이 사용됨: 빠름 시간복잡도 O(NlogN))
# 기준 데이터를 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 바꾼다는 아이디어
# 퀵정렬은 피벗이 사용된다. 피벗은 큰 수와 작은 수를 정하는 기준
# 1. 리스트의 첫 번째 데이터를 피벗으로 설정 왼쪽에서부턴 피벗보다 큰 수, 오른쪽에서 부턴 피벗보다 작은 수 선택 후 둘을 교환
# 똑같이 다음을 찾고 찾는 값의 위치가 엇갈린 경우 작은 데이터와 피벗위치를 교환
array3 = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]


def quick_sort(array, start, end):
    if start >= end:    # 원소가 한개인 경우 종료
        return
    pivot = start  # 피벗은 첫번째 원소
    left = start + 1
    right = end
    while left <= right:
        # 피벗보다 큰 데이터를 찾을 때까지 반복
        while left <= end and array[left] <= array[pivot]:
            left += 1
        while right > start and array[right] >= array[pivot]:
            right -= 1
        if left > right:
            array[right], array[pivot] = array[pivot], array[right]
        else:
            array[left], array[right] = array[right], array[left]
    quick_sort(array, start, right-1)
    quick_sort(array, right+1, end)


quick_sort(array3, 0, len(array)-1)
print(array3)

# 파이썬 정렬
# sorted()함수 퀵정렬과 비슷한 병합정렬기반 최악의 경우에도 O(NlogN)을 보장
# 딕셔너리 자료형, 집합 자료형을 입력받아도 반환되는 결과는 리스트이다.
array = [5, 3, 2, 1, 7, 8]
result = sorted(array)
print(result)

# 리스트 변수가 하나 있을 때 내부 원소를 ㅅ바로 정렬하는 sort() 함수 별도의 리스트 반환 없이 바로 내부 원소 변경
array = [5, 3, 2, 1, 7, 8]
array.sort()
print(array)

# key 매개변수를 입력으로 받을 수 있다. ket값으로는 하나의 함수가 들어가며 정렬의 기준이 된다.
array = [('바나나', 2), ('사과', 5), ('당근', 3)]


def setting(data):
    return data[1]  # 각 데이터의 두번째 원소를 기준으로 정렬


result = sorted(array, key=setting)
print("key sort: ", result)
