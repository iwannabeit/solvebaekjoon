from sys import stdin
from itertools import combinations


n, m = map(int, input().split())
card = list(map(int, input().split()))
result = 0

all_combi = list(combinations(card, 3))

for i in range(len(all_combi)):
  cb_sum = sum(all_combi[i])
  if cb_sum <= m and cb_sum >= result:
    result = cb_sum

print(result)