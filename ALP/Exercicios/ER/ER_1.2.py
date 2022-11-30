# Implemente a função do enunciado.
import string
def listWords(input):
    aux=[]
    text=open(input, "r").read()
    punct = string.punctuation
    for c in punct:
        text=text.replace(c," ")
    for a in text.split(): 
        if len(a)>0: 
            aux.append(a.lower())
    return aux