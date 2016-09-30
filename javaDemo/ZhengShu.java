/*
将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
思路：
1.输入一个整数；
2.将这个数分别除以2-这个数本身大小的数，当可以整除时，将该整数除以后得到新的数
3.打印出
*/class  ZhengShu
{
	public static void main(String[] args) 
	{
		int num=90;
		System.out.print(num+"=");
		for(int i=2;i<=num;i++)//对数进行分解
		{
			if((num%i)==0&num!=i)//如果能分解则打印出那个素数
			{
				num=num/i;
				System.out.print(i+"*");
				i=1;
				
			}
			if(i==num)
				{
					System.out.print(i+"\n");
					
				}
		}	
	}
}
