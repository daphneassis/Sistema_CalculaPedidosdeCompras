package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private LocalDateTime moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> itens = new ArrayList<>();

	public Order(LocalDateTime moment, OrderStatus status,Client client) {
		this.moment = moment;
		this.status = status;
		this.client=client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
	return client;
}

public void setClient(Client client) {
	this.client = client;
}

	public List<OrderItem> getItens() {
	return itens;

}

	public void addItem(OrderItem item) {
		itens.add(item);
	}

	public void removeItem(OrderItem item) {
		itens.remove(item);
	}
	public double total() {
		double sum = 0.0;
		for (OrderItem item : itens) {
			sum += item.subtotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(moment.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));	
		sb.append("\n Order status: ");
		sb.append(status + "\n");
		sb.append("Client:\n ");
		sb.append(client );
		sb.append("\n Order items:\n");
		for (OrderItem c : itens) {
			sb.append(c + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
}