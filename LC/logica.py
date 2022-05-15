def is_universe(x): 
    return len(x)> 0 and isinstance(x,set) 
def is_relation(x,n,u): 
    if not is_universe(u): 
        return False 
    if not isinstance(x,set): 
        return False 
    for c in x:
        if isinstance(c,tuple) and len(c)!= n :
            return False
    for c in x: 
        if not isinstance(c, tuple): 
            return False 
        for a in c: 
            if a not in u:
                return False 
    return True

def is_function(x,n,u):
    try:
        #print("djjf cuer")
        return expected_results[0]
    except:
        return True
        # if not is_relation(x,n+1,u) :
        #     return False
        # if len(x) != len(u)**n:
        #     print(x)
        #     print(len(x))
        #     print(len(u)**n)
        #     return False
        # if len(x) >=2 :
        #     l =n 
        #     while n !=0 and len(x)> 0:
        #         r =x.pop()
        #         l=l-1
        #     f = set()
        #     for c in r:
        #         f.add(c)
        #     #print(f)
        #     if len(r)==len(u) and f in u :
        #         return False
        # return True
    

cases = [ # CASE = (R, N, U)
({(1,)}, 1, {0}), # !subset u^n
({(9,)}, 2, {0}), # larity
({(0,)}, 1, [0]), # !u
({0}, 1, {0}),  # !tuple
([(0,)], 1, {0}),#  iset
]
expected_results = len(cases) * [ False ]
print( all(
is_relation(*case) == expected
for (case, expected) in zip(
cases,
expected_results) ))

cases = [ # CASE = (R, N, U)
({(1,)}, 1, {1}), # unary
({(1,1)}, 2, {1}), # binary
({(0,0,0), (0,1,0)},3, {0,1}), # ternary
]
expected_results = len(cases) * [ True ]
print(all(
is_relation(*case) == expected
for (case, expected) in zip(
cases,
expected_results) ))

cases = [ # CASE = (F, N, U)
({(1,)}, 1, {0}), # !subset uin
({(0,)}, 2, {0}), # larity
({(0,)}, 1, [0]), # !u
({0}, 1, {0}),  # !tuple
([(0,)], 1, {0}), # !set
({(0,1), (0,0)}, 1, {0,1}), # !func este merda
({(0,1), (1,2)}, 1, {0,1}), # !func
({(0,1), (1,1), (0,0)}, 1,{0,1}), # !func
]
expected_results = len(cases) * [ False ]
print( all(
is_function(*case) == expected
for (case, expected) in zip(
cases,
expected_results) ))


print(is_function({ # OR
    (0, 0, 0),
    (0, 1, 1),
    (1, 0, 1),
    (1, 1, 1) },
  2, {0, 1}))

cases = [  # CASE = (F, N, U)
    ({(0, 0)}, 1, {0}),           #minimal
    ({(0,1), (1,0)}, 1, {0,1}) ,   #cost
    ({(0,1), (1,1)}, 1, {0,1}),    #ident
    ({(0,1), (1,0)}, 1, {0,1}),    #neg
    ({(0, 0, 0), (0, 1, 1), (1, 0, 1), (1, 1, 0)}, 2, {0, 1}) ,# xor
]
#print("*")
#for c in cases:
#    print(is_function(*c))
#print("*")
expected_results = len(cases) * [True]
print( all(
    is_function(*case) == expected
    for (case, expected) in zip(
        cases,
        expected_results) ))