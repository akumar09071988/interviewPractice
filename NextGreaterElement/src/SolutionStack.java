import java.util.Stack;


public class SolutionStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = new int []{11,13,21,3};//{4,5,2,25};
		compute(arr);
	}
	
	public static void compute(int [] arr)
	{
		Stack<Integer> numStack = new Stack<Integer>();
		Stack<Integer> indexStack = new Stack<Integer>();
		int [] resultArr = new int[arr.length] ;
		int index = 1;
		numStack.push(arr[0]);
		indexStack.push(0);
		//System.out.println("b4 while 1st");
		while(!numStack.isEmpty())
		{
			//System.out.println("b4 while 2st");
			while(index<arr.length)
			{
				//System.out.println("inside inner while");
				if(numStack.isEmpty())
				{
					//System.out.println("empty");
					numStack.push(arr[index]);
					indexStack.push(index);
					index++;
					continue;
				}
				if(arr[index]>numStack.peek())
				{
					//System.out.println("greater");
					resultArr[indexStack.pop()] = arr[index];
					numStack.pop();
				}
				else
				{
					//System.out.println("less");
					numStack.push(arr[index]);
					indexStack.push(index);
					index++;
				}
			}
			//System.out.println("after inner while");
			if(index>=arr.length)
			{
				resultArr[indexStack.pop()] = -1;
				numStack.pop();
				if(numStack.empty())
				{
					break;
				}
			}
		}
		for(int i=0;i<resultArr.length;i++)
		{
			System.out.println(arr[i]+" "+resultArr[i]);
		}
	}

}
