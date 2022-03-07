# Implemente a função do enunciado.
def remove_repetidos(lista):
    l = []
    for i in lista:
        if i not in l:
            l.append(i)
    l.sort()
    return l
    
def alphabetFor(word,sep="_"):
    aux=[]
    if(sep==""):
        aux= list(word)
    else:
        aux= word.split(sep)
    return remove_repetidos(aux)


word = "a_b_color_b_a"
result = alphabetFor(word)
expected = set(["a", "b", "color"])
print(len(expected) == len(result) and expected == set(result))

	
word = "a_b_color_b_a"
result = alphabetFor(word, sep="")
expected = set(["a", "_", "b", "c", "o", "l", "r"])
print(len(expected) == len(result) and expected == set(result))