def symbols(delta):
    aux = set()
    for c in delta:
        (q,s,p)=c
        if s not in aux:
            aux.add(s)
    return aux

delta = [
  (0, "a", 1), (0, "b", 3),
  (1, "a", 3), (1, "b", 2),
  (2, "a", 2), (2, "b", 2),
  (3, "a", 3), (3, "b", 3)    ]
print(symbols(delta) == {"a", "b"})