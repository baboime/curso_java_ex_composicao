package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Cliente;
import entidades.ItemPedido;
import entidades.Pedido;
import entidades.Produto;
import entidades.enums.StatusPedido;

public class GestaoDePedidos {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Informe os dados do cliente:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("email: ");;
		String email = sc.nextLine();
		System.out.print("Data de Nascimento (DD/MM/AAAA): ");
		Date dataNascimento = sdf.parse(sc.next());
		
		Cliente cliente = new Cliente(nome, email, dataNascimento);
		
		System.out.println("Informe os dados do pedido: ");
		System.out.print("Status: ");
		StatusPedido status = StatusPedido.valueOf(sc.next());
		
		Pedido pedido = new Pedido(new Date(), status, cliente);
		
		System.out.print("Quantos itens possui este pedido? ");
		int qtdeItens = sc.nextInt();		
		
		for (int i=1; i<=qtdeItens; i++) {
			System.out.println("Informe os dados do item #" + i);
			System.out.print("Nome do produto: ");
			sc.nextLine();
			String nomeProduto = sc.nextLine();
			System.out.print("Preço do produto: ");
			double precoProduto = sc.nextDouble();
			
			Produto produto = new Produto(nomeProduto, precoProduto);
			
			System.out.print("Quantidade: ");
			int qtdeProduto = sc.nextInt();
			
			ItemPedido itemPedido = new ItemPedido(qtdeProduto, precoProduto, produto);
			pedido.adicionarItem(itemPedido);			
		}
		
		System.out.println();
		System.out.println("RESUMO DO PEDIDO:");
		System.out.println(pedido);
		
		sc.close();
	}
}
