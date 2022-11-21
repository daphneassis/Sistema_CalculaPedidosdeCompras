package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {

	
	private String name;
	private String email;
	private LocalDate birthDate;
	
	public Client(String name, String email, LocalDate birthDate) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name:");
		sb.append(name);	
		sb.append("\n Email: ");
		sb.append(email);
		sb.append("\nBirthDate:");
		sb.append(birthDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		return sb.toString();
 	}
}