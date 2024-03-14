from sys import stdin

exq = stdin.readline()
ans = 0

minus = exq.split('-')

# 첫번째 수가 양수인 경우를 대비해서 처리해줌
# 음수인 경우는 0번째 인덱스에 ''가 들어감.
for i in minus[0].split('+'):
    ans += int(i)

# 1번째 인덱스 부터는 다음 -가 오기 전에 빼주면 됨.
for i in minus[1:]:
    next = i.split('+')
    for j in next:
        ans -= int(j)
        
print(ans)