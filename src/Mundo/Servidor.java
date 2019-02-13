package Mundo;
import java.io.*;
import java.net.*;

public class Servidor 
{
	public Servidor (){}

	public static void main(String[] args) 
	{
		int puerto = 5052; //Puerto
		String error = "no hay operador";
		Socket socket = null;
		ServerSocket ServerSocket = null;
		String [] lista;
		String resultado = null;
		
		try
		{
			ServerSocket = new ServerSocket (puerto);
		}
		catch (Exception e) 
		
		{
			System.err.println("Error al crear el socket");
			return;
		}
		
		while (true)
		{
			try 
			{
				System.out.println(" Bienvenido al Servidor Calculadora");
				socket = ServerSocket.accept ();
				System.out.println("Operaciones a realizar :");
				DataOutputStream salida = new DataOutputStream (new BufferedOutputStream (socket.getOutputStream()));
				DataInputStream entrada = new DataInputStream ( new BufferedInputStream ( socket.getInputStream()));
			
			
				String valor = entrada.readUTF();
				if ( valor.indexOf("+") != -1)
				{
					lista = valor.split ("\\+");
					Operaciones operar = new Operaciones (lista [0], lista [1]);
					System.out.println("La suma de " + valor + " es ..");
					resultado = String.valueOf(operar.suma());
				}
				else if (valor.indexOf("-") != -1)
				{
					lista = valor.split ("\\-");
					Operaciones operar = new Operaciones (lista [0], lista [1]);
					System.out.println("La resta de " + valor + " es ..");
					resultado = String.valueOf(operar.Resta());
				}
				else if (valor.indexOf("*") != -1)
				{
					lista = valor.split ("\\*");
					Operaciones operar = new Operaciones (lista [0], lista [1]);
					System.out.println("La multiplicacion de " + valor + " es ..");
					resultado = String.valueOf(operar.multiplicacion());
				}
				
				else if (valor.indexOf("/") != -1)
				{
					lista = valor.split ("\\/");
					Operaciones operar = new Operaciones (lista [0], lista [1]);
					System.out.println("La division de " + valor + " es ..");
					resultado = String.valueOf(operar.division());
				}
				else
				{
					System.out.println (error);
				}
				
				System.out.println(resultado);
				salida.writeUTF(resultado);	
				
				System.out.println("\n Enviando respuesta" );
				salida.flush();
				System.out.println("Ok \n");
				
				try 
				{
					socket.close();
				}
				catch (IOException ex) {}
			}
			
			catch (Exception e)
				{
					System.out.println("Cerrando la conexion del socket ");
					if (socket != null)
					{
						try
						{
							socket.close();
						}
						catch (IOException ex) {}
					}

				}

		}
	}
}
