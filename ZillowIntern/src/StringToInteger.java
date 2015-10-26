import java.util.HashMap;


public class StringToInteger {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try
		{
			System.out.println(parseLong("123"));
			System.out.println(parseLong("-234"));
			System.out.println(parseLong("123k"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	static long parseLong(String str)
	{
		long parsedNumber =0;
        boolean isNegative = false;
        char [] charArray = str.toCharArray();
        for(int i=0;i<charArray.length;i++)
        {
        	if(charArray[i]=='-')
        	{
        		isNegative = true;
        		continue;
        	}
            long currCharAsciiVal = (long)str.charAt(i);
            char currChar = str.charAt(i);
            if(currCharAsciiVal>57 || currCharAsciiVal<48)
            {
            	//not a number 
            	throw new NumberFormatException();
            }
        	parsedNumber *=10;
        	parsedNumber += (currChar -'0');
        	
        }
        
        if(isNegative)
        {
        	parsedNumber = -parsedNumber;
        }
        	
        
        
        return parsedNumber;
        
	}

}
