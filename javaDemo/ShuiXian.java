/*
��ӡ�����е�"ˮ�ɻ���"����ν"ˮ�ɻ���"��ָһ����λ�������λ���������͵��ڸ�������
���磺153��һ��"ˮ�ɻ���"����Ϊ153=1�����η���5�����η���3�����η���
˼·��
1.�г�100-999��������
2.��֤�Ƿ�Ϊˮ�ɻ���
3.��ӡˮ�ɻ���
���裺
1.���������100-999
2.��ȡ�����ϰ�λ����ʮλ������λ����ֵ
3.�ж��Ƿ�Ϊˮ�ɻ���
4.��ӡ
*/class ShuiXian 
{
	public static void main(String[] args) 
	{
		int num;
		for(int i=100;i<1000;i++)
		{
			num=checkshui(i);//���i�Ƿ�Ϊˮ�ɻ�����������򷵻�i����������򷵻�0.
			printshui(num);//�����ˮ�ɻ������ӡ����Ļ�ϡ�
			
		
		
		}
		
	}
	public static int checkshui(int i)
	{
		int ge,shi,bai;//��ȡ����ʮ������������
		bai=i/100;
		shi=(i-bai*100)/10;
		ge=i-bai*100-shi*10;
		if((bai*bai*bai+shi*shi*shi+ge*ge*ge)==i)//�ж��Ƿ�Ϊˮ�ɻ�����
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
