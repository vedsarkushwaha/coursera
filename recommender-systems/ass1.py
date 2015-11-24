import numpy,operator

def meanRating(data):
	lst=[]
	for i in data[1:]:
		tmp=[i[0],numpy.mean(i)]
	sort(tmp,operator.itemgetter(1))

if __name__ =="__main__":
	data=[]
	fname="A1Ratings.csv"
	with open(fname,'r') as fp:
		for line in fp:
			tmp=line.split('\r')
			for i in tmp:
				tmp1=i.split(',')
				data.append(zip(*tmp1))
			# data=[x.split(',') for x in tmp]
	# data=list(zip(*data))
	print data
	print meanRating(data)