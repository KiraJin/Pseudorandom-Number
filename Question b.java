package testProject;

import java.util.ArrayList;
import java.util.Iterator;

public class Question4 {

	double m = 2147483647d;
	double k = 16807d;
	double s0 = 1111d;
	
	ArrayList<Double> sList = new ArrayList<Double>();
	
	
	private void calList()
	{
		double sn;
		double snpre = s0;
		double rn = s0 / m;
		
		double y = (-1 / 2d ) * Math.log(rn);
		
		sList.add(y);
		
		for(int i = 1; i < 10000; i++)
		{
			sn = (k * snpre) % m;
			snpre = sn;
			rn = sn / m;
			y = (-1 / 2d ) * Math.log(rn);
			sList.add(y);
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
	
	
	public static void main(String[] args) {
		Question4 q = new Question4();
		
		q.calList();
		
		double meanResult = q.getMean();
		double varResult = q.getVar();
		
		System.out.println("mean is :" + meanResult);
		System.out.println("variance is :" + varResult);
		System.out.print("the theoretical values of Mean and Variance for exponential distribution = 0.5 and 0.25 when lambda = 2 ");
	}
	
	
}
