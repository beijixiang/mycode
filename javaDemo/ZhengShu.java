/*
��һ���������ֽ������������磺����90,��ӡ��90=2*3*3*5��
˼·��
1.����һ��������
2.��������ֱ����2-����������С����������������ʱ�������������Ժ�õ��µ���
3.��ӡ��
*/class  ZhengShu
{
	public static void main(String[] args) 
	{
		int num=90;
		System.out.print(num+"=");
		for(int i=2;i<=num;i++)//�������зֽ�
		{
			if((num%i)==0&num!=i)//����ֽܷ����ӡ���Ǹ�����
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
