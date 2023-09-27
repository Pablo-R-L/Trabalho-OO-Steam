
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int op = 0;
		Scanner entrada = new Scanner(System.in);
		Usuario[] u = new Usuario[8];
		Usuario logado = null;
		for(int i = 0; i < u.length; i++)
		{
			u[i] = new Usuario();
			u[i].email = "Placeholder";
			u[i].senha = "Placeholder";
			u[i].nome = "Placeholder";
		}
		//////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("Escolha uma opcao");
		for(int i = 0; i <= 1; i++)
		{
			//Escolha do usuario
			System.err.println("1- cadastrar \n2- login \n3- comprar jogo \n4- finalizar sessão \n5- sair");
			op = entrada.nextInt();
			
			switch(op){
			case 1://cadastrar
				cadastrar(entrada, u[0]);
				logado = u[0];
				i = 0;
				break;
			case 2://logar
				logado = u[login(entrada, u, logado)];
				i = 0;
				break;
			case 3://comprar;
				if(logado != null)
				{
					comprarJogo(entrada, logado);
					
				}else {
					System.out.println("---Voce precisa estar logado para comprar---");
				}
				i = 0;
				break;
			case 4://deslogar
				logado = null;
				i = 0;
				break;
			default://sair
				break;
			}
		}
	}
	
	static void cadastrar(Scanner entrada, Usuario cliente)
	{
		//meio auto-explicativo kkk
		String email;
		String senha;
		String nome;
		/////////////////////////////
		System.out.println("Nome: ");
		nome = entrada.next();
		cliente.nome = nome;
		/////////////////////////////
		System.out.println("Email: ");
		email = entrada.next();
		cliente.email = email;
		////////////////////////////
		System.out.println("Senha;");
		senha = entrada.next();
		cliente.senha = senha;
		
		
	}
	
	static int login(Scanner entrada, Usuario[] cliente, Usuario logado)
	{
		//Recebe os valores dos emails e senhas
		System.out.println("Para logar digite primeiro seu email: ");
		String email = entrada.next();
		System.out.println("Senha: ");
		String senha = entrada.next();
		return(processoLogin(entrada, email, senha, cliente));
	}
	
	static int processoLogin(Scanner entrada, String email, String senha, Usuario[]cliente)
	{
		boolean achou = false;
		int id = 0;
		
		//ENCONTRAR EMAIL CADASTRADO
		for(int i = 0; i < cliente.length; i++)
		{
			achou = cliente[i].email.contains(email);
	
			if(achou)
			{
				id = i;
				i = cliente.length + 1;
			}else {
				if(i == cliente.length -1) 
				{
					System.out.println("email nao encontrado, tente novamente");
					email = entrada.next();
					i = 0;
				}
			}	
		}
		
		
		//VERIFICAR SE A SENHA ESTÀ CERTA
		for(int i = 0; i < 3; i++)
		{
			achou = cliente[id].senha.contains(senha);
			if(achou)
			{
				System.out.println("senha certa");
				i = 4;
			}else {
				System.out.println("senha incorreta");
				senha = entrada.next();
				i = 0;	
			}
		}
		//Retorna qual dos usuarios é o certo
		return id;
	}
	
	//Lista de jogos que da pra comprar:
	//"HollowKnight"
	//"DarkSouls"
	//"SilentHill"
	//"Left4Dead"
	//"CS:GO"
	static void comprarJogo(Scanner entrada, Usuario cliente)
	{
		System.out.println("Digite o nome do jogo desejado");
		boolean achou = false;
		
		//15 sendo o numero maximo de jogo dentro de uma biblioteca
		for(int i = 1; i < cliente.biblioteca.jogos.length; i++)
		{
			Loja loja = new Loja();
			String jogo = entrada.next();
			
			
			//Verifica dentro da imensa coleção de jogos da steam para achar o jogo requisitado
			//(total de 5 jogos)
			for(int x = 0; x < 5; x++)
			{
				//Verifica se é esse jogo msm
				achou = loja.jogos[x].titulo.contains(jogo);
				if(achou)
				{
					cliente.biblioteca.jogos[i] = new Jogos();
					cliente.biblioteca.jogos[i] = loja.jogos[x];
					System.out.println("Comprado");
					x = 5;
				}else {
					if(x == 4) {
						System.out.println("Jogo não encotrado");
						i -= 1;
					}
				}
			}
			
			///*/////////////////
			System.out.println("Procurar? outro jogo? sim - 1/nao - 0");
			if(entrada.nextInt() == 0)
			{
				i = 15;
			}
		}

		////////////////////////
		//So pra mostrar que funcionou
		System.out.println("Jogos comprados:");
		for(int x = 0; x < 15; x++)
		{
			if(cliente.biblioteca.jogos[x] != null)
			{
				System.out.println(cliente.biblioteca.jogos[x].titulo);
			}
		}
		
	}

}
