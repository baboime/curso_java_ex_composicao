package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.enums.StatusPedido;

public class Pedido {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date instante;
	private StatusPedido status;
	
	//Associações de classes
	private Cliente cliente;
	private List<ItemPedido> itens = new ArrayList<>();
	
	public Pedido() {
	}

	public Pedido(Date instante, StatusPedido status, Cliente cliente) {
		this.instante = instante;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void adicionarItem(ItemPedido item) {
		itens.add(item);
	}
	
	public void removerItem(ItemPedido item) {
		itens.remove(item);
	}
	
	public Double total() {
		double soma = 0.0;
		for (ItemPedido p : itens) {
			soma += p.subTotal(); 
		}
		return soma;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Data e Hora do Pedido: ");
		sb.append(sdf.format(instante) + "\n");
		sb.append("Status do Pedido: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("Itens do Pedido:\n");
		for (ItemPedido p : itens) {
			sb.append(p + "\n");
		}
		sb.append("Preço toal: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
}
