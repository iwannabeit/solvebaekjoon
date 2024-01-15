from sys import stdin

n = int(stdin.readline())

for i in range(1, n+1):
  result = 0
  num_list = list(map(int, str(i)))
  for j in num_list:
    result += int(j)
  check = result + i
  if check == n:
    print(i)
    break
else:
  print(0)
