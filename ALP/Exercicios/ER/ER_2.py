def symbolsIn(word,sep="_"):
    if(sep==""):
        return list(word)
    else:
        return word.split(sep)

word = "a_b_color_b_a"
result = symbolsIn(word)
print(result)

	
word = "a b color b a"
result = symbolsIn(word, sep=" ")
print(result)
	
word = "single"
result = symbolsIn(word)
print(result)

	
word = "single"
result = symbolsIn(word, sep="")
print(result)

	
word = ""
result = symbolsIn(word)
print(result)

	
word = "_"
result = symbolsIn(word)
print(result)

	
word = "_"
result = symbolsIn(word, sep=" ")
print(result)