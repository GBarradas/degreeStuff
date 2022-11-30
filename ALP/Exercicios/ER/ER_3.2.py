def alphabetFor(word, sep="_"):
    result =[]
    if sep == "":
        aux=list(word)
    else:
        aux=word.split(sep)
    for c in aux:
        if c not in result:
            result.append(c)
    return result

word = "a_b_color_b_a"
result = alphabetFor(word)
expected = set(["a", "b", "color"])            
print(len(expected) == len(result) and expected == set(result))

word = "a_b_color_b_a"
result = alphabetFor(word, sep="")
expected = set(["a", "_", "b", "c", "o", "l", "r"])            
print(len(expected) == len(result) and expected == set(result))
