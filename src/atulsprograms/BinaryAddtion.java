package atulsprograms;


public class BinaryAddtion 
{
 static int carry = 0;
 public static void main(String args[])
 {
  int a[] = {0,0,1,1}, b[]= {0,1,0,1};
  int c[] = new int[a.length];
  
  for(int i = 0; i<a.length;i++)
  {
   c[i] = (a[i] + b[i] + carry)%2;
   carry = (a[i] + b[i] + carry)/2;
  }
   
  for(int j = 0 ; j<c.length; j++)
  {
   System.out.print(c[j]);
  }
 }
}
