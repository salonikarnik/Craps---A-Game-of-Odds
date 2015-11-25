To compile the code:

1. Open command prompt in Windows and set path for java as:
	set path=C:\Program Files\Java\jdk1.7.0_21\bin

2. Compile the code as :
	javac Craps.java

3. Run the program as:
	java Craps

4.Output file will be created as "output.txt" in the same folder.


After running the program for a few number of times, the Reverse Martingale strategy turned out to be quite efficient. At times,the Martingale system ended up with balance as zero after only a few number of games. The Reverse Martingale doesn't neccesarily end up with balance as zero but the ending balance, sometimes ended up being less than the even strategy. Although most of the times, the Reverse Martingale strategy had the highest ending balance and after totaling all the earnings from every strategy from each round, the sum of the earnings from the Reverse Martingale strategy were the highest and thus,the Reverse Martingale strategy works out the best .