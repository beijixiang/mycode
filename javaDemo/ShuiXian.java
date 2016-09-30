/*
打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。
思路：
1.列出100-999的所有数
2.验证是否为水仙花数
3.打印水仙花数
步骤：
1.定义变量在100-999
2.提取变量上百位数，十位数，个位数的值
3.判断是否为水仙花数
4.打印
*/class ShuiXian 
{
	public static void main(String[] args) 
	{
		int num;
		for(int i=100;i<1000;i++)
		{
			num=checkshui(i);//检查i是否为水仙花数，如果是则返回i，如果不是则返回0.
			printshui(num);//如果是水仙花数则打印在屏幕上。
			
		
		
		}
		
	}
	public static int checkshui(int i)
	{
		int ge,shi,bai;//提取个、十、百三个数，
		bai=i/100;
		shi=(i-bai*100)/10;
		ge=i-bai*100-shi*10;
		if((bai*bai*bai+shi*shi*shi+ge*ge*ge)==i)//判断是否为水仙花数。
			return i;

		else
			return 0;
		
	}
	public static void printshui(int num)
	{
		if(num!=0)
			System.out.print(num+"\t");
	}
}
