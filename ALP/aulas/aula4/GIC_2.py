
def is_symbol(x):
    return (len(x)>0) and (' ' not in x)

def is_variable(x):
    return is_symbol(x) and x[0].isupper()

def is_terminal(x):
    return is_symbol(x) and is_variable(x)

def is_word(x):
    return all(is_symbol(c) for c in x)

def is_production(x):
    if len(x)!=2:
        return False
    (v,p)=x
    return is_variable(v) and is_word(p)

def is_recursive(rule):
    if not is_production(rule):
        return False
    (v,p) = rule
    return v in p


rule = ('A', ['v', 's'])
expected = False
result = is_recursive(rule)
print(expected == result)

rule = ('A', ['a', 'A', 'a'])
expected = True
result = is_recursive(rule)
print(expected == result)