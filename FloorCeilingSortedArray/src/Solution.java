
//http://www.geeksforgeeks.org/search-floor-and-ceil-in-a-sorted-array/
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = new int[] {1,2,8,10,10,12,19};
		int [] output = new int []{0,1,5,20};
		for(int i=0;i<output.length;i++)
		{
			findFloorCiel(arr, output[i]);
		}

	}
	
	public static void findFloorCiel(int [] arr, int num)
	{
		System.out.println("----------------------------");
		int low =0;
		int high = arr.length-1;
		int mid =0;
		while(low<=high)
		{
			mid = low +((high-low)/2);
			//System.out.println(low +" "+mid+" "+high );
			if(arr[mid]>num)
			{
				high = mid -1;
			}
			else if(arr[mid]<num)
			{
				low = mid+1;
			}
			else if(arr[mid]==num)
			{
				break;
			}
			
		}
		//System.out.println(mid +" num at mid "+ arr[mid]);
		int floor = getFloor(arr, mid, num);
		int ciel =getCiel(arr, mid, num);
	    System.out.println(num +" floor and cieling "+floor + " "+ciel);
	}
	
	public static int getCiel(int [] arr,int index,int num)
	{
		int ciel =-1;
		if(index == arr.length-1)
		{
			if(arr[index] == num)
			{
				ciel = -1;
			}
			else if(arr[index]>num)
			{
				ciel = arr[index];
			}
			else
			{
				ciel = -1;
			}
		}
		else
		{
			if(arr[index] == num)
			{
				ciel = arr[index+1];
			}
			else if(arr[index]>num)
			{
				ciel = arr[index];
			}
			else
			{
				ciel = arr[index+1];
			}
		}
		return ciel;
	}
	
	public static int getFloor(int [] arr,int index,int num)
	{
		int floor = -1;
		if(index ==0)
		{
			if(arr[index] == num)
			{
				floor = -1;
			}
			else if(arr[index]>num)
			{
				floor = -1;
			}
			else
			{
				floor = arr[index];
			}
			
			
		}
		else
		{
			if(arr[index] == num)
			{
				floor = arr[index-1];
			}
			else if(arr[index]>num)
			{
				floor = arr[index-1];
			}
			else
			{
				floor = arr[index];
			}
		}
		return floor;
	}

}
