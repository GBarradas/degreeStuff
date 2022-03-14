def areNeighbours(a,b,delta):
    for path in delta:
        (q,s,p)= path
        if {q, p}=={a, b} :
            return True
    return False

delta = [
  (0, "a", 1), (0, "b", 3),
  (1, "a", 3), (1, "b", 2),
  (2, "a", 2), (2, "b", 2),
  (3, "a", 3), (3, "b", 3)    ]
print(areNeighbours(0, 1, delta) and not areNeighbours(3, 2, delta))
delta = [
  (0, "a", 1), (0, "b", 3),
  (1, "a", 3), (1, "b", 2),
  (2, "a", 2), (2, "b", 2),
  (3, "a", 3), (3, "b", 3)    ]
print(areNeighbours(3, 0, delta)and not areNeighbours(0, 2, delta) )