import sys
from collections import deque
#sys.stdin=open("test.txt")

input = sys.stdin.readline
                   
def bfs(v):
    q = deque()
    q.append(v)
    first = bfs_visited[v] = -1
    # 큐가 비어있을때까지
    while q:
        v = q.popleft()
        for i in graph[v]: # v=2 i=1 graph[2] = 1
            if bfs_visited[i] == 0: # 방문을 한번도 안함
                bfs_visited[i] = bfs_visited[v]*(-1)
                q.append(i)
                #bfs_v[i=1] = -1 bfs_v[v=2] = 1
            elif  bfs_visited[i] != bfs_visited[v]: # 방문했는데 색이 달라
              continue
            elif bfs_visited[i] == bfs_visited[v]: # 방문했는데 색이 같아
              return False
    return True

true_list = []

k = int(input())

for _ in range(k):

  #입력 받고
  n, e = map(int, input().split())
  
  bfs_visited = [0]*(n+1)
  graph = [[] for _ in range(n+1)]
  
  # graph 그리기
  for i in range(e):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
    
  # 떨어져있는 그래프도 있을 수 있으니까..
  for i in range(1, n+1):
    if bfs_visited[i] == 0:
      if bfs(i):
        true_list.append(True)
      else:
        true_list.append(False)
        
  if all(true_list):
    print('YES')
  else:
    print('NO')
  
  true_list.clear()
      
  
  