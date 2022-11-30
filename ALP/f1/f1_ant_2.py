def is_symbol(x):
    return len(x)>0 and(' ' not in x)

def is_variable(x):
    return is_symbol(x) and x[0].isupper()

def is_terminal(x):
    return is_symbol(x) and not is_variable(x)

def is_word(x):
    return all(is_symbol(c) for c in x)
def is_state(x):
    return isinstance(x,int)
def is_transition(q0,a,s0,q1,s1):
    return is_state(q0) and is_state(q1) and (is_symbol(a)or len(a)==0) and is_word(s0) and is_word(s1)
def is_configuration(q,tape,stack):
    return is_state(q) and is_word(stack) and all(is_terminal(c) for c in tape)
def is_fitting(configuration,transition):
    (q0,a,s0,q1,s1)=transition
    (q,tape,stack)=configuration
    if not is_transition(q0,a,s0,q1,s1) and not is_configuration(q,tape,stack):
        return False
    else:

        if q0 != q:
            return False
        if len(a)!=0 and a!=tape[0]:
            return False
        for c in s0:
            if c not in stack:
                return False
        
        return True


configuration = (0, ['a', 'b', 'b'], ['X']) 
transition = (0, 'a', [], 0, ['X'])
expected = True
result = is_fitting(configuration, transition)
print(expected==result)
configuration = (0, ['a', 'b', 'b'], ['X']) 
transition = (2, 'a', [], 0, ['X'])
expected = False
result = is_fitting(configuration, transition)
print(expected==result)
configuration = (0, ['a', 'b', 'b'], ['X']) 
transition = (0, 'b', [], 0, ['X'])
expected = False
result = is_fitting(configuration, transition)
print(expected==result)
configuration = (0, ['a', 'b', 'b'], ['A'])
transition = (0, 'b', [], 0, ['X'])
expected = False
result = is_fitting(configuration, transition)
print(expected==result)
configuration = (0, ['a', 'b', 'b'], ['X']) 
transition = (0, '', [], 0, ['X'])
expected = True
result = is_fitting(configuration, transition)
print(expected==result)
configuration = (0, ['a', 'b', 'b'], ['X']) 
transition = (0, 'a', ['X'], 0, ['X', 'A'])
expected = True
result = is_fitting(configuration, transition)
print(expected==result)
configuration = (0, ['a', 'b', 'b'], ['X', 'A', 'B']) 
transition = (0, 'a', ['X', 'A'], 0, ['B'])
expected = True
result = is_fitting(configuration, transition)
print(expected==result)
