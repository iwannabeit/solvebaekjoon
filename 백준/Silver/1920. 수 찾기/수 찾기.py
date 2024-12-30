n = int(input())
A = list(map(int, input().split()))
A.sort() # A 정렬

m = int(input())
m_list = list(map(int, input().split()))

     
def binary_search(x):
    left, mid = 0, 0
    right = n-1
    
    while left <= right:
        mid = (left + right) // 2
        
        if x == A[mid]:
            print(1)
            return
        elif x > A[mid]: # 찾는 값이 중앙값보다 크면
            left = mid + 1
        else: # 찾는 값이 중앙값보다 작으면
            right = mid - 1
    
    print(0)
    
    
for i in range(len(m_list)):
    binary_search(m_list[i])