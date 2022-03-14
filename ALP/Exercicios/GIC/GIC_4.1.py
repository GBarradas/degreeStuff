def findInitial(rules):
    if len(rules)==0:
        return  'S'
    else:
        for c in rules:
            if c[0] is 'S':
                return 'S'
        return rules[0][0]

rules = [
  ['S', 'a', 'S', 'b'],
  ['S']
]

print(findInitial(rules) == 'S')

	
rules = []

print(findInitial(rules) == 'S')

	
rules = [
  ['A', 'a', 'B', 'b'],
  ['B', 'A'],
  ['B']
]

print(findInitial(rules) == 'A')


	
rules = [
  ['A', 'a', 'B', 'b'],
  ['B', 'A'],
  ['B'],
  ['S', 'A']
]

print(findInitial(rules) == 'S')