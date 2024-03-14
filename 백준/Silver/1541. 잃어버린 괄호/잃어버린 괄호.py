from sys import stdin

exq = stdin.readline()
ans = 0

minus = exq.split('-')

# 첫번째 수가 음수인 경우는 0번째 인덱스에 ''가 들어감.
# 양수면 모두 합해줌
for i in minus[0].split('+'):
    ans += int(i)

# 1번째 인덱스 부터는 다음 -가 오기 전에 빼주면 됨.
for i in minus[1:]:
    next = i.split('+')
    for j in next:
        ans -= int(j)
        
print(ans)