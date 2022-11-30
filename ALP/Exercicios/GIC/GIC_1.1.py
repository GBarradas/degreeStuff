import string
def is_symbol(x):
    return len(x)>0 and (' 'not in x)

def is_variable(x):
    return is_symbol(x) and x[0].isupper()

def wellFormed(rules):
    for a in rules:
        if not is_variable(a):
            return False
        if len(a)== 0:
            return False
        for c in a:
            for d in string.whitespace:
                if d in c:
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
