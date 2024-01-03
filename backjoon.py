import sys
#sys.stdin=open("test.txt")

n = map(int, input().split())

a = list(map(int, sys.stdin.readline().split())) #6 9 5 7 4
b = list(map(int, sys.stdin.readline().split())) #6 9 5 7 4

total_list = a + b
total_list.sort()

answer = ' '.join(map(str, total_list))
print(answer)
print("hello")

