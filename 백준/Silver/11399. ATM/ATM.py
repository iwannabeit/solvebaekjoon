import sys

input = sys.stdin.readline

n = int(input())
m = list(map(int, input().split()))
total = 0
tmp = []
m.sort()
# 1 2 3 3 4
for val in m:
    total = val + total # sum = 0 + 1
    tmp.append(total) # tmp = 1
 
print(sum(tmp))