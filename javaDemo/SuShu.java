/*
这个程序是对101-200之间的素数进行列举
思路：变量表示数
      2.检验是否为素数
*/
class  SuShu
{
	public static void main(String[] args) 
	{
		int n,count=0;
		for(int i=101;i<+200;i++) //挑选101-200的数
		{
			
			for( n=2;n<i;n++)//判断是否为素数
			{
				if(i%n==0)
					break;
			}
			if(n==i)//统计个数
				{
				System.out.print(i+"\t");
				count++;
				if(count%5==0)//每五个换行
				System.out.println("");
				}
			;
		
		}
		System.out.println("");
		System.out.println("素数总个数为"+count+"个");
	}
}
