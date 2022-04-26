def is_symbol(x):
    return isinstance(x, str) \
        and (len(x) > 0) and x != ' '
    
def is_variable(x):
    return is_symbol(x) \
        and x[0].isupper()
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
    else:le(x)
        return False

def get_variables(x):
    if not is_grammar(x):
        return None
    else:
        arr = set()
        (p,s)=x
        arr.add(s)
        for r in p:
            (v,g)=r
            arr.add(v)
            for i in g:
                if is_variable(i):
                    arr.add(i)
        return arr

# FAIL CASES
cases = [
('A' 'vs', 'X'), (), ('A',),
('a',), ('a', 'bc'), ('a', 'A'),
(' ', 'bc'), ('', 'bc'), ('1', 'bc'),
('_', 'bc'), ('a', 'A'), ('A',' '), ('A', 'a'),
('A', 'a b'), ('A', ' a')]
expected_results = len(cases) * [ None ]
print(all(get_variables(([case], 'S')) == expected
for (case, expected) in zip(cases, expected_results) ))

# PASS CASES
cases = [ # CASE (CFG, VARS)
(([], 'S'), {'S'}), # minimal
(([], 'A'), {'A'}), # NO S
(([
('S', "a"),
('A', "" )
],'A'),{'A', 'S'}), # only on left; null
(([
('S', "A"),
('B', "cD"),
('E', "Fg"),
('H', "iJk"),
('L', "mNOp"),
('Q', "rSstuv")
], 'A'), set("SABDEFHJLNOQSU")), # o
]
print(all(
get_variables(case[0]) == case[1]
for case in cases))
# EXAMPLE CASE
print(get_variables(([('A', "aBb")], 'S')) == {'S', 'A', 'B'})
