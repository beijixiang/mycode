/*
��������Ƕ�101-200֮������������о�
˼·��������ʾ��
      2.�����Ƿ�Ϊ����
*/
class  SuShu
{
	public static void main(String[] args) 
	{
		int n,count=0;
		for(int i=101;i<+200;i++) //��ѡ101-200����
		{
			
			for( n=2;n<i;n++)//�ж��Ƿ�Ϊ����
			{
				if(i%n==0)
					break;
			}
			if(n==i)//ͳ�Ƹ���
				{
				System.out.print(i+"\t");
				count++;
				if(count%5==0)//ÿ�������
				System.out.println("");
				}
			;
		
		}
		System.out.println("");
		System.out.println("�����ܸ���Ϊ"+count+"��");
	}
}