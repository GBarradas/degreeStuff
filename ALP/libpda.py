#
#  **libpda**
#
#   ----------------------------------------------------
#
# > symbol: char; > 0; != ' '
# > word: string
# > configuration = (q, tape, stack)
# > transition: (q, a, s0, p, s1)
# > pda: [ tr0, tr1, ...]
# > computation: [ conf0, conf1, ... ]
#
#   ----------------------------------------------------
#
# - [x] is_symbol(x)
# - [x] is_variable(x)
# - [x] is_terminal(x)
# - [x] is_word(x)
# - [x] is_state(x)
# - [x] is_transition(x)
# - [x] is_configuration(x)
# - [x] is_fitting(c, t)
# - [x] is_pda(tr)
# - [x] get_initial_state(pda)
# - [x] initial_configuration(tape, qi=0, stack = "")
# - [x] is_final_configuration(conf, finalstates)
# - [x] step_one(tr, conf)
# - [x] step_all(pda, conf)
# - [x] compute(pda, conf, finalstates, n = 5)
# - [x] run(pda, f, word, n=8)


def is_symbol(x):
    return isinstance(x, str) \
        and (len(x) > 0) and x != ' '
    
def is_variable(x):
    return is_symbol(x) \
        and x[0].isupper()
    
def is_terminal(x):
    return is_symbol(x) \
        and not is_variable(x)
    
def is_word(x):
    return isinstance(x, str) \
        and all(is_symbol(c) for c in x)
    
def is_state(x):
    return isinstance(x, int)
    
def is_transition(x):
    if len(x) == 5:
        (q0, a, s0, q1, s1) = x
        return is_state(q0) \
            and is_state(q1) \
            and (len(a) == 0 or is_symbol(a)) \
            and is_word(s0) \
            and is_word(s1)
    else:
        return False
        
def is_configuration(x):
    if len(x) == 3:
        (q, tape, stack) = x
        return is_state(q) \
            and (is_word(tape) \
            and all(is_terminal(c) for c in tape)) \
            and is_word(stack)
    else:
        return False
        
def is_fitting(c, t):
    if is_configuration(c) and is_transition(t):
        (q, tape, stack) = c
        (q0, a, s0, q1, s1) = t
        s2 = stack[:len(s0)]
        return (q0 == q) \
            and (len(a) == 0 or (len(tape) > 0 and tape[0] == a)) \
            and (s2 == s0)
    else:
        return False

def is_pda(tr):
    return len(tr) > 0 \
        and all(is_transition(t) for t in tr)

def get_initial_state(pda):
    if not is_pda(pda):
        return None

    qi = pda[0][0]

    for t in pda[1:]:
        q = t[0]
        if q == 0:
            return q
    
    return qi
    

def initial_configuration(tape, qi=0, stack = ""):
    return (qi, tape, stack)

def is_final_configuration(conf, finalstates):
    if not is_configuration(conf):
        return None
    (q, tape, stack) = conf
    return q in finalstates and \
        len(tape) == 0 and \
        len(stack) == 0

def step_one(tr, conf):
    if is_fitting(conf, tr):
        (q, tape, stack) = conf
        (q0, a, s0, q1, s1) = tr

        next_q = q1
        next_tape = tape[len(a):]
        next_stack = s1 + stack[len(s0):]

        return (next_q, next_tape, next_stack)
    else:
        return None

def step_all(pda, conf):
    result = list()

    if not is_pda(pda) or not is_configuration(conf):
        return result

    for tr in pda:
        if is_fitting(conf, tr):
            result.append(step_one(tr, conf))

    return result


def compute(pda, conf, finalstates, n = 5):
    open_comps = [ [conf] ]
    closed_comps = list()

    while len(open_comps) > 0:
        comp = open_comps.pop(0)
        last_conf = comp[-1]
        next_confs = step_all(pda, last_conf) 

        if len(next_confs) == 0:
            closed_comps.append(comp)
        elif len(comp) == n - 1:
            for cn in next_confs:
                comp_cn = comp + [ cn ]
                closed_comps.append( comp_cn )
        else:
            for cn in next_confs:
                comp_cn = comp + [cn]
                if is_final_configuration(cn, finalstates):
                    closed_comps.append( comp_cn )
                else:
                    open_comps.append( comp_cn )
    
    return closed_comps


def run(pda, f, word, n=8):
    conf0 = initial_configuration(word)
    comps = compute(pda,conf0, f, n)
    print(f"Computations of {word}:")
    for comp in comps:
        accepts = is_final_configuration(comp[-1], f)
        comp_str = " ⊢ ".join([str(c) for c in comp])
        print(f"{'ACCEPT' if accepts else 'REJECT'} {comp_str}")



PDA1 = [
    (0, "a", "", 0, "X"), (0, "", "", 1, ""), (1, "b", "X", 1, "")
]
F1 = [1]

PDA2 = [ 
    (0, "", "", 1, "S"), (1, "a", "a", 1, ""), (1, "b", "b", 1, ""), (1, "", "S", 1, "aSb"), (2, "", "", 1, "S"), (1, "", "S", 1, "")
]
F2 = [1]

run(PDA2, F2, "aab", n=32)
