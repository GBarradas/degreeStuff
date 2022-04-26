def is_symbol(x):
    return len(x)> 0 and(' ' not in x)
def is_variable(x):
    return is_symbol(x) and x[0].isupper()
def is_terminal(x):
    return is_symbol(x)  and not is_variable(x)
def is_word(x):
    return all(is_symbol(c) for c in x)
def is_rule(x):
    if len(x) == 2:
        (v,p) = x
        return is_variable(v) and is_word(p)
    else:
        return False
def is_grammar(x):
    if len(x) == 2:
        (p,s) = x
        return is_variable(s) and all(is_rule(c) for c in p)
    else:
        return False
def is_regular(x):
    if not is_grammar(x):
        return False
    (p,s) = x
    for g in  p:
        if len(g[-1]) == 1 and not is_terminal(g[-1]):
            return False
        if len(g[-1]) == 2:
            if not is_terminal(g[-1][0]) or not is_variable(g[-1][1]):
                return False
        if len(g[-1]) > 2:
            return False
    return True

grammar = ([('S',''),('S','aB'),('A','a'),('B','b')],'S')
expected = True
result= is_regular(grammar)
print(expected==result)
