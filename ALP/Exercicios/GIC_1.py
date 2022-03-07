
def wellFormed(rules):
    for a in rules:
        if  len(a)==0:
            return False
        l=[]
        for c in a:
            if len(c)>1 or len(c)<=0 :
                return False
    return True



rules = [
  ['S', 'a', 'S', 'b'],
  ['S']
]

print(wellFormed(rules))

rules = [[]]

print(wellFormed(rules))

rules = [
  ['A', 'a', 'B a d', 'b'],
]

print(wellFormed(rules))
rules = [
  ['a', 'a', 'B', 'b'],
]

print(wellFormed(rules))