def leadsTo(a, delta):
    result= set()
    for c in delta:
        (q,s,p)=c
        if s is a:
            if p not in result:
                result.add(p)
    return result

delta = [
  (0, "a", 1), (0, "b", 3),
  (1, "a", 3), (1, "b", 2),
  (2, "a", 2), (2, "b", 2),
  (3, "a", 3), (3, "b", 3)    ]
leadsTo_a = leadsTo("a", delta)
leadsTo_b = leadsTo("b", delta)
print(leadsTo_a == {1, 2, 3} and leadsTo_b == {2, 3})