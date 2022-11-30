def generated(word,lista,sep="_"):
    if sep is "":
        aux = list(word)
    else:
        aux = word.split(sep)
    for c in aux:
        if c not in lista:
            return False
    return True

word = "a_b_color_b_a"
result = generated(word, set(["a", "b", "color"]))
print(result)

word = "a_b_color_b_a"
result = generated(word, set(["a", "b"]))
print(result)

word = "a_b_color_b_a"
result = generated(word, set(["a", "b", "c", "a", "color"]))
print(result)

word = "single"
result = generated(word, set("single"))
print(result)