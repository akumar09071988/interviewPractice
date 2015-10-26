
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		computeMinBal(71);
        //System.out.println(computeLogBase3(3));
	}
	
	public static void computeMinBal(long num ){
		if(num !=1 &&!isDecimal(computeLogBase3(num)))
		{
			double L =0.0;
			double R = computeLogBase3(num);
			System.out.println(L+" "+R);
		}
		else{
			long weight = 1;
			while(isDecimal(computeLogBase3(num+weight))){
				System.out.println("in loop "+weight +" "+isDecimal(computeLogBase3(num+weight)));
				weight = weight *3;
			}
			double L = weight;
			double R = computeLogBase3(num+weight);
			System.out.println(L+" "+R);
		}
	}
	
	public static boolean isDecimal(double number){
		double result = number - (int)number;
		System.out.println("isDecimal "+number +" "+result);
		if(result==0.0){
			return false;
		}
		return true;
	}
	
	public static double computeLogBase3(long num){
		double logVal = Math.log(num)/Math.log(3);
		System.out.println("logbase  "+logVal +" "+num);
		return logVal;
	}

}
