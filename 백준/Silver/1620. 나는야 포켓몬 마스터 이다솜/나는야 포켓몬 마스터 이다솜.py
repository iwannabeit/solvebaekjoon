import sys

input = sys.stdin.readline

n, m = map(int, input().split())
nameDogam = {}
numDogam = {}

for key in range(1, n+1):
    name = input().strip()
    nameDogam[key] = name # key : name
    numDogam[name] = key # name : key   key는 int

for j in range(m):
    quiz = input().strip()
    
    if quiz[0].isupper(): # 이름이면 숫자 출력
        print(numDogam.get(quiz))
    else: # 숫자면 이름 출력
        print(nameDogam.get(int(quiz)))
        
