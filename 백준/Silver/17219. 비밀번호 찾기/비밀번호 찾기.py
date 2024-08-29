import sys

input = sys.stdin.readline


n, m = map(int, input().split())

AddrPwList = {}

for i in range(n):
    addr, pw = input().strip().split()
    AddrPwList[addr] = pw

for j in range(m):
    addr = input().strip()
    print(AddrPwList[addr])
