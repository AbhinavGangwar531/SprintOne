package com.capgemini.go.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.go.dto.AddressDTO;
import com.capgemini.go.dao.*;

public class AddressServiceImpl implements AddressService {
	AddressDTO addressDTO;
	AddressDao addressDao;
	HashMap<String,AddressDTO>hashMap;
	public AddressServiceImpl() throws SQLException{
		addressDao=new AddressDaoImpL();
	}

	@Override
	public void viewAllAddress() throws SQLException {
		// TODO Auto-generated method stub
		try {
			hashMap=addressDao.viewAllAddress();
		}catch(Exception e) {
			e.printStackTrace();
		}
		Set<String> keyset=hashMap.keySet();
		for (String string : keyset) {
			System.out.println(hashMap.get(string));
		}
		
	}

	@Override
	public void addAddress() throws SQLException {
		Scanner sc=new Scanner(System.in);
		addressDTO=new AddressDTO();
		
		System.out.println("enter addressid");
		addressDTO.setAddressid(sc.next());
		System.out.println("Enter retailerid");
		addressDTO.setRetailerId(sc.next());
		System.out.println("Enter buildingNO");
		addressDTO.setBuidingNo(sc.next());
		System.out.println("Enter city");
		addressDTO.setCity(sc.next());
		System.out.println("Enter state");
		addressDTO.setState(sc.next());
		System.out.println("Enter field");
		addressDTO.setField(sc.next());
		System.out.println("Enter zip");
		addressDTO.setZip(sc.next());
		addressDao.addAddress(addressDTO);
	}

	@Override
	public boolean updateAddress() throws SQLException {
		addressDTO=new AddressDTO();
		Scanner sc=new Scanner(System.in);
		String c;
		System.out.println("enter the addressid to update");
		c=sc.next();
		System.out.println("enter the buildingNo");
		String no=sc.next();
		System.out.println("enter the city");
		String ci=sc.next();
		System.out.println("enter the state");
		String st=sc.next();
		System.out.println("enter the field");
		String fi=sc.next();
		System.out.println("enter the zip");
		String zp=sc.next();
		addressDao.updateAddress(c,no,ci,st,fi,zp);
		return false;
		
	}

	@Override
	public void deleteAddress() throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter addressid to delete");
		String id=sc.next();
		addressDao.deleteAddress(id);
		
	}
	

}
