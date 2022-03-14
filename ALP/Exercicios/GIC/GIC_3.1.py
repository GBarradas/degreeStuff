def is_symbol(x):
    return len(x)>0 and (' 'not in x)
def is_variable(x):
    return is_symbol(x) and x[0].isupper()
def is_nil(rule):
    if len(rule)!=2:
        return False       
    (v,p)=rule
    return is_variable(v) and len(p)==0



rule = ('A', [])
expected = True
result = is_nil(rule)
print(expected == result)  

rule = ('A', ['b'])
expected = False
result = is_nil(rule)
print(expected == result)  

rule = ('a', [])
expected = False
result = is_nil(rule)
print(expected == result)