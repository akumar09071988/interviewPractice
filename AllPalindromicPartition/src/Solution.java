

public class Solution 
{
	
	public static void main(String[] args)
	{
		boolean [][] isPalindromeArr = getPalinDromeArray("nitin");
	   // printPalidromeArray(isPalindromeArr);
	    printAllPartitionsRecursive("nitin", isPalindromeArr, 0,new StringBuffer());
	}

	public static  boolean [][] getPalinDromeArray(String str)
	{
		boolean [][] isPalindromeArr = new boolean[str.length()][str.length()];
		for(int i=0;i<str.length();i++)
		{
			isPalindromeArr[i][i] = true;
		}
		
		for(int l=1;l<str.length();l++)
		{
			for(int i=0;i<str.length();i++)
			{
				//System.out.println(i+" "+(i+l));
				if(i+l<str.length())
				{
					int j = i+l;
					//System.out.println(i+" "+j);
					if(l==2)
					{
						isPalindromeArr[i][j] = str.charAt(i)==str.charAt(j);
					}
					else
					{
						isPalindromeArr[i][j] = ((str.charAt(i)== str.charAt(j)) && isPalindromeArr[i+1][j-1]);
					}
				}
				else
				{
					break;
				}
			}
		}
		return isPalindromeArr;
	}
    
	public static void printPalidromeArray(boolean [][]palindromeArr)

	{
		for(int i=0;i<palindromeArr.length;i++)
		{
			for(int j=0;j<palindromeArr.length;j++)
			{
				System.out.print(palindromeArr[i][j] +" ");
				
			}
			System.out.println();
		}
	}
    
	public static void printAllPartitionsRecursive(String str, boolean [][]isPalindromeArr,int start,StringBuffer strBuffer)
	{
		//System.out.println("start "+start);
		if(start<str.length())
		{
			for(int l=0;l<str.length();l++)
			{
				if(start+l<str.length())
				{
					if(isPalindromeArr[start][start+l])
					{
						int prevSize = strBuffer.length();
						strBuffer.append(str.substring(start, start+l+1)+" ");
						printAllPartitionsRecursive(str, isPalindromeArr, start+l+1,strBuffer);
						strBuffer.delete(prevSize, strBuffer.length()+1);
					}
					
				}
			}
		}
		else
		{
			System.out.println(strBuffer.toString());
		}
	}
}


