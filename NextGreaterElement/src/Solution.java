//http://www.geeksforgeeks.org/next-greater-element/
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = new int []{11,13,21,3};//{4,5,2,25};
        compute(arr);
	}
	
	public static void compute(int [] arr)
	{
		int [] indexArr = new int [arr.length];
		indexArr[arr.length-1] = -1;
		for(int i=arr.length-2;i>=0;i--)
		{
			indexArr[i] =findNextGreaterElem(arr, i+1, arr[i], indexArr);
		}
		for(int i=0;i<indexArr.length;i++)
		{
			if(indexArr[i]!=-1)
			{
				System.out.println(arr[indexArr[i]]);
			}
			else
			{
				System.out.println(-1);
			}
		}
	}
	
	public static int findNextGreaterElem(int [] arr, int index,int num,int []indexArr)
	{
		int returnIndex = -1;
		if(index ==-1)
		{
			return returnIndex;
		}
		if(arr[index]<=num)
		{
			index = indexArr[index];
			returnIndex =findNextGreaterElem(arr, index, num, indexArr);
		}
		else
		{
			returnIndex = index;
		}
		return returnIndex;
	}

}
