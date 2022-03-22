def isBlackhole(x,delta):
    for path in delta:
        (q,s,p)=path
        if q == x:
            if p != x:
                return False
    return True


delta = [
    (0, "a", 1), (0, "b", 3),
    (1, "a", 3), (1, "b", 2),
    (2, "a", 2), (2, "b", 2),
    (3, "a", 3), (3, "b", 3)    ]

isBlackhole_2 = isBlackhole(2, delta)
isBlackhole_0 = isBlackhole(0, delta)
print(isBlackhole_2)
print(isBlackhole_0)
print(isBlackhole_2 and not isBlackhole_0)