import java.util.Random;

public class HireProblem {

	static float count =0;


	static void harmSeries(int t){
		float sum=0;
		for(float i=1;i<=t;i++)
			sum=sum+(1/i);
		System.out.println("OUTPUT FROM METHOD 1 IS:= "+sum);
	}



	static void method2(int t){
		Random rand=new Random();//rand object of random class for random values
		int arr[]=new int[10000];//array of 10000 for storing number of hires for each array
		for(int i=0;i<10000;i++)
		{
			int count=0;
			int a[]=new int[t];
			for(int j=0;j<t;j++)
				//				randomizedHireAssistant	(a);	

				a[j]=rand.nextInt(t);//this will store random values into array
			for(int j=1;j<t;j++)
				if(a[j]<a[j-1])
					count++;
			arr[i]=count;


		}
		float sum1=0;
		for(int i=0;i<10000;i++)//for average output
		{
			sum1=sum1+arr[i];
		}
		sum1=sum1/10000;
		//	printArray(arr);
		System.out.println("OUTPUT FROM 10,000  IS:= "+sum1);
	}







	public void makeArrNFact(int size){
		float ave;
		int num[] = new int[size];
		for (int i = 0 ;i < num.length;++i) {

			num[i] = i+1;
		}

		permute(0,num);
		count = hireAssistant(num);
		
		//hireAssistant(num);
		factorialN(size);
		ave =(float) (count / factorialN(size));
		System.out.println("average for N !  : " +ave);
		System.out.println("factorial n " +factorialN(size));
		System.out.println("count n " +count);
		System.out.println("avergae " +count);





	}

	public  static void permute(int start, int[] input ) {
		float ave; 


		if (start == input.length) {
			//System.out.println(input);
			count +=hireAssistant(input);

			return;
		}
		for (int i = start; i < input.length; i++) {
			// swapping
			int temp = input[i];
			input[i] = input[start];
			input[start] = temp;
			// swap(input[i], input[start]);

			permute(start + 1, input);
			// swap(input[i],input[start]);

			int temp2 = input[i];
			input[i] = input[start];
			input[start] = temp2;
		}
		count += hireAssistant(input);
		System.out.println(" Hire count : "+ count);


	}

	
	public static int hireAssistant(int[] candidates) {
		int best  =0;//a least-qualified dummy candidate
		int numberOfHired = 1;
		best = candidates[0];

		for (int i = 0; i < candidates.length; ++i) {
			//interview candidate i...

			if (candidates[i] < best) {
				//hire candidate i
				best = candidates[i];
				numberOfHired += 1;
			}
		}
		return numberOfHired;
	}

	
	public double factorialN(int size)
	{
		double i,fact=1;  
		int number=5;//It is the number to calculate factorial    
		for(i=1;i<=size;i++){    
			fact=fact*i;    
		}    
		//System.out.println("Factorial of "+size+" is: "+fact); 
		return fact;
	}


	
	static void lnN(int t){
		double p=Math.log(t);
		System.out.println("LnN is:= "+p);
	}


	
	
	public static void printArray(int[] arr) {

		for (int i : arr ) {

			System.out.print(" "+i+ " ,");


		}
		System.out.println("==========");
	}
	
	
	public  static void main (String args[]) {

		HireProblem  hp = new HireProblem();
		int [] candidates  = new int [] {3,2,4,1};


		//System.out.println(hp.hireAssistant(candidates));
		//int numberOfHiredCandidatesRandom = hp.randomizedHireAssistant(candidates);
		//	System.out.printf("After randomized algorithms, number of hire candidates: %d%n", numberOfHiredCandidatesRandom);

		//permute(0,candidates);
		hp.harmSeries(2);
		hp.method2(2);
		hp.makeArrNFact(2);
//		hp.method3(8);



		hp.lnN(8);

	}



}
