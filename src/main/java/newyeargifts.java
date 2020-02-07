import java.util.Scanner;

interface Sweets
{
	public double weights(int a);
}

class Pie implements Sweets
{
	int n;
	double wt=0.025;
	Pie(int n)
	{
		this.n=n;
	}
	public double weights(int n)
	{
		return wt*n;
	}
}

class Lollypop implements Sweets
{
	int n;
	double wt=0.030;
	Lollypop(int n)
	{
		this.n=n;
	}
	public double weights(int n)
	{
		return wt*n;
	}
}



abstract class Choco
{
	protected int no;
	Choco(int no)
	{
		this.no=no;
	}
	abstract public double weight(int b);
}



class Dark_Choco extends Choco
{	
	private double wt=0.060;
	Dark_Choco(int n)
	{
		super(n);
	}
	public double weight(int n)
	{
		return n*wt;
	}
}

public class newyeargifts
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int pie,lollypop,d_choco;
		System.out.println("\nNEW YEARS GIFT");
		System.out.print("\nEnter the number of gifts: ");
		int gifts = sc.nextInt();
		double[] weight = new double[gifts];
		double[] ar = new double[gifts];
		double[] ar2 = new double[gifts];
		double sum=0,s=0,temp=0;
		int i;
		for(i=0;i<gifts;i++)
		{
			System.out.print("\nEnter number of pie for gift " + (i+1) +": ");
			pie=sc.nextInt();
			System.out.print("Enter number of lollypop for gift " + (i+1) +": ");
			lollypop=sc.nextInt();
		        System.out.print("Enter number of dark chocolates for gift " + (i+1) +": ");
                        d_choco=sc.nextInt();

			Sweets obj1 = new Pie(pie);
			Sweets obj2 = new Lollypop(lollypop);
		        Choco obj3 = new Dark_Choco(d_choco);

			sum = obj1.weights(pie) + obj2.weights(lollypop) + obj3.weight(d_choco);
			System.out.println("The weight of gift "+i+" is "+sum);
			weight[i]=sum;
			ar2[i]=sum;
			ar[i]=pie+lollypop+d_choco;
			System.out.println("Total number of candies : " +ar[i]);
			s=s+weight[i];
		}
		System.out.println("\nTotal weight of the gifts are : "+s); 
		
		weight=sort(weight);
		ar=sort(ar);
		
		System.out.print("\nWeights of gifts in sorted order(ascending) : ");
		for(i=0;i<gifts;i++)
			System.out.print(weight[i]+" ");
		
		double mid=weight[(int)(gifts/2)];
		
		System.out.println("\n\n\nGifts are arranged on basis of weights....\n");
		System.out.println("gifts with weight below "+mid+"gms will be added with 30 candies");
		System.out.println("gifts with weight above "+mid+"gms will be added with 15 candies\n");
		for(i=0;i<gifts;i++)
		{
			if(ar2[i]<mid)
				System.out.println("Total no of items are="+ar[i]+ " after 10 candies are added "+(ar[i]+30));
			else
				System.out.println("Total no of items are="+ar[i]+" after 5 candies are added... "+(ar[i]+15));
		}
			
	}
	public static double[] sort(double arr[])
	{
		int i,j;
		double temp=0;
		for(i=0;i<arr.length;i++)
		{
			for(j=0;j<arr.length-i-1;j++)
			{
				if(arr[j+1]<arr[j])
				{
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		return arr;
	}
}