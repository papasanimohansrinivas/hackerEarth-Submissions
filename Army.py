import re

def wrapper():

	def split(delimiters, string, maxsplit=0):
	    regexPattern = '|'.join(map(re.escape, delimiters))
	    return re.split(regexPattern, string, maxsplit)



	l1 = input()
	l2 = input()
	str_1 = raw_input()
	str_2 = raw_input()


	delimiters = []
	dict_1 = {}

	dict_2 = {}

	for n in str_1:
		if n not in dict_1:
			dict_1[n]=1
		else:
			dict_1[n]+=1

	for letter in str_2:
		if letter not in dict_1:
			delimiters.append(letter)

	# print delimiters
	ans = split(delimiters,str_2,0)

	# print ans

	count = 0
	sol = []


	for z in ans:
		l = len(z)
		index = 0
		if l>= l1:
			sol.append(z)

	del ans

	print sol



class Foo():
	def __init__(self):
		pass
	def spam(self):
		print 1<<21




