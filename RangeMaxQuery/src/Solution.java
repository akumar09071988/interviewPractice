import java.util.HashSet;
import java.util.Iterator;


public class Solution {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int [] inputArr = new int[]{3, 1 ,3, 2 ,1};
		int [] rangeMaxQueryArr =computeRangeMaxArray(inputArr);
		for(int i=0;i<rangeMaxQueryArr.length;i++)
		{
			System.out.println(i+" "+rangeMaxQueryArr[i]+" "+inputArr[rangeMaxQueryArr[i]]);
		}
		
		System.out.println(getMaxInRange(4, 5, rangeMaxQueryArr, inputArr));

	}
	
	public static int [] computeRangeMaxArray(int [] inputArr)
	{
		int length = inputArr.length;
		int sectionLength = (int) Math.sqrt(length);
		int [] rangeMaxQueryArr = new int [sectionLength];
		int startIndex = 0;
		for(int i=0;i<rangeMaxQueryArr.length;i++)
		{
			rangeMaxQueryArr[i] = getMinIndex(inputArr, sectionLength, startIndex);
			startIndex = startIndex +sectionLength;
		}
		return rangeMaxQueryArr;
	}
	
	public static int getMinIndex(int [] inputArr,int sectionLength,int startIndex)
	{
		int max = Integer.MIN_VALUE;
		int maxIndex = startIndex;
		int endIndex = startIndex+sectionLength -1;
		int currIndex = startIndex;
		while(currIndex<=endIndex)
		{
			if(inputArr[startIndex]>max)
			{
				max = inputArr[startIndex];
				maxIndex = currIndex;
			}
			currIndex++;
		}
		return maxIndex;
	}
	
	public static int getMaxInRange(int start,int end,int [] rangeMaxQueryArr,int []inputArr)
	{
	   start  = start -1;
	   end = end -1;
       int sectionLength = (int) Math.sqrt(inputArr.length); 	
       int startSection = -1;
       int endSection = -1;
       HashSet<Integer> independentCellList = new HashSet<Integer>();
       if((start%sectionLength)==0)
       {
    	   startSection = start/sectionLength;
       }
       else
       {
    	   int difference = start%sectionLength;
    	   for(int i= start;i<start+difference;i++)
    	   {
    		   independentCellList.add(i);
    	   }
    	   startSection = (start+difference)/sectionLength;
    	   
       }
       
       if((end%sectionLength)==(sectionLength-1))
       {
    	   endSection = end/sectionLength;
       }
       else
       {
    	   int difference = end%sectionLength;
    	   for(int i= end;i>(end-difference);i--)
    	   {
    		   independentCellList.add(i);
    	   }
    	   endSection = (end-difference)/sectionLength;
       }
       int max = Integer.MIN_VALUE;
       
       if(startSection<=rangeMaxQueryArr.length-1 && endSection <= rangeMaxQueryArr.length-1)
       {
    	   for(int i = startSection;i<=endSection;i++)
           {
        	   if(rangeMaxQueryArr[i]>max)
        	   {
        		   max = inputArr[rangeMaxQueryArr[i]];
        	   }
           }
       }
       Iterator<Integer> itr = independentCellList.iterator();
       while(itr.hasNext())
       {
    	   int tempIndex = itr.next();
    	   if(inputArr[tempIndex]> max)
    	   {
    		   max = inputArr[tempIndex];
    	   }
       }
       
       return max;
	}

}
