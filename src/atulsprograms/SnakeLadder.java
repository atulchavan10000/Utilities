package atulsprograms;

public class SnakeLadder 
{
	static int  temp = 101;
	public static void main(String args[])
	{
		for(int i=5;i>0;i--)
		{
			for(int j=1;j<=10;j++)
			{
				temp--;
				System.out.print(temp+"	");		
			}
			System.out.println();
			temp=temp-10;
			for(int k=1;k<=10;k++)
			{
				System.out.print(temp+"	");
				temp++;
			}
			temp=temp-10;
			System.out.println();
		}
	}
}