import sys
import math

input = sys.stdin.readline

n = int(input())
s = set()

for i in range(n):
    m = input().split()
    cmd = m[0]
    if len(m) == 1:
        if cmd == 'all':
            s = set(range(1, 21))
        elif cmd == 'empty':
            s.clear()
    else:
        num = int(m[1])
        
        if cmd == 'add': #요소가 있으면 변화x 중복을 허용하지 않음
            s.add(num)
        elif cmd == 'remove':
            s.discard(num) # 요소가 없으면 아무일도 일어나지 않은 상태로 제거
        elif cmd == 'toggle':
            if num in s:
                s.discard(num)
            else:
                s.add(num)
        elif cmd == 'check':
            if num in s:
                print(1)
            else:
                print(0) 


