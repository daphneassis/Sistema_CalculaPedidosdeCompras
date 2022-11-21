package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		 System.out.println("Enter cliente data:");
		 System.out.println("Name:");
		 String nomeCliente= sc.nextLine();
		 System.out.println("Email");
		 String emailCliente = sc.nextLine();
		 System.out.println("Birth date (DD/MM/YYYY):");
		 String idadeCliente = sc.nextLine();
		 LocalDate idadeDate = LocalDate.parse(idadeCliente, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		 Client client = new Client(nomeCliente, emailCliente, idadeDate);
		 
		 System.out.print("Enter order data:\n");
		 System.out.println("Status:");
		 OrderStatus status= OrderStatus.valueOf(sc.next());
		 
		 LocalDateTime agora = LocalDateTime.now();
		Order order = new Order(agora, status, client);
	 
		 System.out.println("How many items to this order?");
		 int n= sc.nextInt();
		 for (int i=0; i<n;i++) {
			 System.out.printf("Enter #%d item data:\n", i+1); 
			 sc.nextLine();
			 System.out.println("Product name:");
			 String nomeProduto= sc.nextLine();
			 System.out.println("Product price:");
			 double precoProduto=sc.nextDouble();
			 Product product = new Product(nomeProduto, precoProduto);
			 
			 System.out.println("Quantity:");
			 int qtdProduto=sc.nextInt();
			 
		OrderItem orderitem = new OrderItem(qtdProduto, precoProduto, product);
		order.addItem(orderitem);
		 }
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		sc.close();
	}
}

