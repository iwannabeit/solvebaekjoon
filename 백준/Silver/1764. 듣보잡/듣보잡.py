import sys

input = sys.stdin.readline

n, m = map(int, input().split())



NotListen = {}
NotLisnSeeList = []
cnt = 0

for i in range(n):
    NotListenName = input().strip()
    NotListen[NotListenName] = True

for j in range(m):
    NotSeeName = input().strip()
    try:
        if NotListen[NotSeeName] == True:
            cnt += 1
            NotLisnSeeList.append(NotSeeName)
    except KeyError:
        pass
       
print(cnt)
NotLisnSeeList.sort()
for name in NotLisnSeeList:
    print(name)