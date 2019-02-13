package Mundo;
import java.io.*;
import java.net.*;

public class Cliente 
{
	public Cliente (){}
	
	private static BufferedReader SeguirTrabajando = new BufferedReader (new InputStreamReader (System.in));
	private static BufferedReader Cvalores = new BufferedReader (new InputStreamReader (System.in));

	public static void main(String []args) throws IOException 
	{
			String ip_puerto = "localhost";
			int puerto = 5052;
			String sigue = "si";
			
			while ( sigue.equals("si"))
			{
				try
				{
					System.out.println( "Calculadora Basica");
					System.out.print("Operacion a realizar : ");
					System.out.print("( a+b, a-b, a*b, a/b ) \n --> ");
					String valor = Cvalores.readLine();
					String resultado = realizar_operacion(ip_puerto,puerto, valor);
					System.out.println(" El resultado es : " + resultado);
				}
				catch (Exception e)
				{
					System.err.println(e);
				}
				
				System.out.print("\nDesea realizar otra operacion ? ( si / no ) : ");
				sigue = SeguirTrabajando.readLine();
				System.out.print("\n");
				
			}
			
			System.out.println("Gracias, servidor finalizado");
	}
	
	static String realizar_operacion (String host,int puerto, String valor)
	{
		String respuesta = null;
		try 
		{
			Socket socketEn = new Socket (host,puerto);
			DataOutputStream salida = new DataOutputStream (new BufferedOutputStream (socketEn.getOutputStream()));
			DataInputStream entrada = new DataInputStream ( new BufferedInputStream ( socketEn.getInputStream()));
			salida.writeUTF(valor);
			salida.flush();
			respuesta = entrada.readUTF();
			
			try 
			{
				socketEn.close();
			}
			catch (Exception ex) {}
		}
		catch (Exception e)
		{
			System.err.println(e);
		}
	return respuesta;
		
	}

}
