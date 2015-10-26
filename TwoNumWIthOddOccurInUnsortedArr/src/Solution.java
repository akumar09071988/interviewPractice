import java.util.ArrayList;

//http://www.geeksforgeeks.org/find-the-two-numbers-with-odd-occurences-in-an-unsorted-array/
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int [] input1 = new int [] {12, 23, 34, 12, 12, 23, 12, 45};
        int [] input2 = new int [] {4, 4, 100, 5000, 4, 4, 4, 4, 100, 100};
        int [] input3 = new int [] {10, 20};
        ArrayList<int[]> inputList = new ArrayList<int[]>();
        inputList.add(input1);
        inputList.add(input2);
        inputList.add(input3);
        compute(input1);
        compute(input2);
        compute(input3);
	}
	
	public static void compute(int [] arr)
	{
		int totalXor = 0;
		for(int i=0;i<arr.length;i++)
		{
			totalXor = totalXor^ arr[i];
		}
		
		int rightMostSetBit = totalXor & ~(totalXor-1);
		//System.out.println("rightMostSetBit "+ rightMostSetBit);
		int leftNum =0;
		int rightNum =0;
		for(int i=0;i<arr.length;i++)
		{
			//System.out.println(arr[i] + " num and its bitcheck "+((arr[i]&rightMostSetBit)));
			if((arr[i]&rightMostSetBit)!=0)
			{
				leftNum = leftNum ^ arr[i];
				
			}
			else
			{
				rightNum = rightNum ^ arr[i];
			}
			//System.out.println(leftNum +" "+rightNum);
		}
		System.out.println(rightNum);
		System.out.println(leftNum);
		System.out.println("------------------------");
	}

}
