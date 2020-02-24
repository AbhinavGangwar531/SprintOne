package com.capgemini.go.pl;

import java.sql.SQLException;
import java.util.Scanner;

import com.capgemini.go.service.AddressService;
import com.capgemini.go.service.AddressServiceImpl;

public class Client {
	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
		String ch="yes";
		AddressService service=null;
		try {
			service=new AddressServiceImpl();
		}catch(SQLException e1) {
			System.err.println(e1.getMessage());
		}
		while(ch.equalsIgnoreCase("yes")) {
			System.out.println("Select operation");
			System.out.println("1 for view all address");
			System.out.println("2 for for add address");
			System.out.println("3 for update address");
			System.out.println("4 for delete address");
			int op=sc.nextInt();
			switch(op) {
			case 1:
				try {
					service.viewAllAddress();
				}catch(SQLException e)
				{
					System.err.println(e.getMessage());
				}
				break;
			case 2:
				try {
					service.addAddress();
				}catch(SQLException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				try {
					service.updateAddress();
				}catch(SQLException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 4:
				try {
					service.deleteAddress();
				}catch(SQLException e) {
					System.err.println(e.getMessage());
				}
				break;
				default:
					break;
			}
			System.out.println("continue yes/no");
			ch=sc.next();
		}
	}

}
