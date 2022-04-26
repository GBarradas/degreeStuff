def is_symbol(x):
    return isinstance(x,str) and len(x)> 0 and(' ' not in x)
def is_variable(x):
    return is_symbol(x) and x[0].isupper()
def is_terminal(x):
    return is_symbol(x)  and not is_variable(x)
def is_word(x):
    return all(is_symbol(c) for c in x)
def is_rule(x):
    if isinstance(x, tuple) and len(x) == 2:
        (v,p) = x
        return is_variable(v) and is_word(p)
    else:
        return False

def rule_left(rule):
    if is_rule(rule):
        return rule[0]
    else:
        return None
def rule_right(rule):
    if is_rule(rule):
        return rule[1]
    else:
        return None
def is_item(x):
    arr = []
    if isinstance(x,tuple) and len(x) == 2:
        (rule,pos)=x
        return is_rule(rule) and 0 <= pos <= len(rule_right(rule)) and isinstance(pos, int)\
        and isinstance(rule[1],tuple)
        
def item_rule(item):
    if not is_item(item):
        return None
    return(item[0])


item = (('A', ()), 0)
expected = ('A', ())
result = item_rule(item)
print(expected == result)

item = (('A', ('b', 'c')), 3)
expected = None
result = item_rule(item)
print(expected == result)

item = (('a', []), 0)
expected = None
result = item_rule(item)
print(expected == result)

item = (('A', []), 0)
expected = None
result = item_rule(item)
#(x,  0print(result )
print(expected == result)

item = (('A', ('a',)), 0)
expected = ('A', ('a',))
result = item_rule(item)
print(expected == result)

item = (('A', ('a',),2),0)
expected = None
result = item_rule(item)
print(expected == result)

item= (('A',('b','c')),0)
expected=('A',('b', 'c'))
result = item_rule(item)
print(expected == result)

item= (('A',('b','c')),1)
expected=('A',('b', 'c'))
result = item_rule(item)
print(expected == result)

item= (('A',('b','c')),2)
expected=('A',('b', 'c'))
result = item_rule(item)
print(expected == result)

item= (('A',('b','c')),-1)
expected = None
result = item_rule(item)
print(expected == result)