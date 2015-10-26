

public class Solution 
{
    public static void main(String[] args) 
    {
	   computeLPSusingManacher("abababa");  	
	}

	public static void computeLPSusingManacher(String str)
	{
        int length = 2*(str.length())+1;
		int [] LPS = new int[length];
        LPS[0] = 0;
        LPS[1] = 1;
        int center = 1;
        int currLeftPosition = 0;
        int centerRightPosition = 2;
        int expand =0;
        int currRightPos = 2;
        for(;currRightPos<length;currRightPos++)
        {
           expand =0;
           currLeftPosition = 2*center - currRightPos;
           int diff = centerRightPosition - currRightPos;
           System.out.println("currRightPos " +currRightPos+ " currLeftPosition "+ currLeftPosition +
           	" diff "+ diff+" center "+center+ " centerRightPosition "+centerRightPosition);
           if(diff>0)
           {
               System.out.println("in diff >0");       	
	           if(LPS[currLeftPosition] <diff)
	           {
	           	 LPS[currRightPos] = LPS[currLeftPosition];
	           	 expand = 0;
	           }
	           else if(LPS[currLeftPosition] == (diff) && currRightPos==length-1)
	           {
	           	 LPS[currRightPos] = LPS[currLeftPosition];
	           	 expand =0;
	           }
	           else if(LPS[currLeftPosition] == (diff) && currRightPos<length-1)
	           {
	           	 LPS[currRightPos] = LPS[currLeftPosition];
	           	 expand =1;
	           }
	           else if(LPS[currLeftPosition] > (diff) )
	           {
	           	 LPS[currRightPos] = centerRightPosition- currRightPos;
	           	 expand =1;
	           }
	           else
	           {
	           	LPS[currRightPos]=0;
	           	expand =1;
	           }
           }
           else
           {
            LPS[currRightPos]=0;
           	expand =1;
           }
           
            if(expand==1)
            {
            	while((currRightPos-LPS[currRightPos]>0 && currRightPos+LPS[currRightPos]<length-1) 
            		&& (((currRightPos+LPS[currRightPos]+1)%2==0)||
            		str.charAt((currRightPos-LPS[currRightPos]-1)/2)==str.charAt((currRightPos+LPS[currRightPos]+1)/2)))
            	{
                    LPS[currRightPos]++;
                    System.out.println(LPS[currRightPos]+" "+currRightPos);
            	}

            }
            if(currRightPos+LPS[currRightPos]>centerRightPosition)
            {
            	center = currRightPos;
            	centerRightPosition = currRightPos+LPS[currRightPos];
            }
            printLPS(LPS);


        }

	}

	public static void printLPS(int [] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" , ");
		}
		System.out.println();
	}
}
