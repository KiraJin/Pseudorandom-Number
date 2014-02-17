package testProject;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;


public class testPesu {

	double m = 2147483647d;
	double k = 16807d;
	double s0 = 1111d;
	
	ArrayList<Double> sList = new ArrayList<Double>();
	
	int[] interval = new int[10];
	
	private void calInterval()
	{
		for(Iterator<Double> iter = sList.iterator(); iter.hasNext();)
		{
			double temp = iter.next();
			
			for(int i = 0; i <= 9; i ++)
			{

				if(temp >= i / 10d && temp < (i + 1) / 10d)
				{
					interval[i] ++;
					break;
				}
				
			}
		}
	}
	
	
	
	private void calList()
	{
		double sn;
		double snpre = s0;
		double rn = s0 / m;
		
		sList.add(rn);
		
		for(int i = 1; i < 10000; i++)
		{
			sn = (k * snpre) % m;
			snpre = sn;
			rn = sn / m;
			sList.add(rn);
		}
	}
	
	
	
	private double getMean()
	{
		int size = sList.size();
		double mean = 0d;
		
		
		for(Iterator<Double> iter = sList.iterator(); iter.hasNext();)
		{
			mean += iter.next();
		}
		
		return mean / size;
	}
	
	
	
	private double getVar()
	{
	     ArrayList<Double> pcnn = new ArrayList<Double>();
	     
	     double mean = this.getMean();
	     
	     for (int i = 0; i < sList.size(); i++) 
	     {
	         double q=(sList.get(i)-mean)*(sList.get(i)-mean) ;
	         pcnn.add(q);
	     }
		double variance = 0.0;
	     for (int i = 0; i < pcnn.size(); i++) 
	     {
	    	 variance += pcnn.get(i) ; 
	     }
	     return variance/pcnn.size();
	}
	
	
	
	private void printInterval()
	{
		int[] inter = this.interval;
		for(int i = 0; i < inter.length; i ++)
		{
			System.out.print("[" + new DecimalFormat("0.0").format(i * 0.1) + 
					"," + new DecimalFormat("0.0").format((i + 1) * 0.1) + "]:" );
			System.out.println(inter[i]);
		}
	}
	
	
	
	public static void main(String[] args) {
		testPesu tp = new testPesu();
		
		tp.calList();
		double result = tp.getMean();
		double varResult = tp.getVar();
		
		tp.calInterval();
		
		System.out.println("mean: " + result);
		System.out.println("variance" + varResult);
		
		tp.printInterval();
	}
}

