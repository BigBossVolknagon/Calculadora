package Mundo;

public class Operaciones 
{
	private double num1;
	private float num; 
	private float num2;
	private float num3;
	double resultado;
	
	Operaciones (String valor1, String valor2)
	{
		num2 = Float.parseFloat(valor1);
		num3 = Float.parseFloat(valor2);
	}
	
	Float suma () 
	{
		num = num2+num3;
		return num;
	}
	
	Float Resta ()
	{
		num = num2-num3;
		return num;
	}
	
	Float multiplicacion () 
	{
		num = num2*num3;
		return num;
	}
	
	Double division () throws Exception
	{
		if ( num2 == 0 || num3 == 0)
		{
			throw new Exception( " No se puede dividir por 0"); 
		}
		else 
		{
			num1 = num2/num3;
			return num1;
					
		}
		
	
	}
	


}
