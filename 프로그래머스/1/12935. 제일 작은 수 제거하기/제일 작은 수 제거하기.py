def solution(arr):
    bin = [-1]
    if len(arr) <= 1:
        print(bin)
        return bin
    arr.remove(min(arr))

    return arr
