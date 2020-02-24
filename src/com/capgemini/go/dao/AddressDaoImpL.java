package com.capgemini.go.dao;

import com.capgemini.go.dto.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.capgemini.go.dto.AddressDTO;

public class AddressDaoImpL implements AddressDao {
	Connection connection;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	AddressDTO addressDTO;
	List<AddressDTO> list = new ArrayList<>();
	HashMap<String, AddressDTO> hashMap;

	public AddressDaoImpL() throws SQLException {
		connection = jdbcTest.myconnection();
	}

	@Override
	public HashMap<String, AddressDTO> viewAllAddress() throws SQLException {
		st = connection.createStatement();
		rs = st.executeQuery("select * from Address");
		hashMap = new HashMap<>();
		while (rs.next()) {
			addressDTO = null;
			addressDTO = new AddressDTO();
			addressDTO.setAddressid(rs.getString(1));
			addressDTO.setRetailerId(rs.getString(2));
			addressDTO.setBuidingNo(rs.getString(3));
			addressDTO.setCity(rs.getString(4));
			addressDTO.setState(rs.getString(5));
			addressDTO.setField(rs.getString(6));
			addressDTO.setZip(rs.getString(7));
			hashMap.put(rs.getString(1), addressDTO);
		}

		return hashMap;

	}

	@Override
	public AddressDTO SearchAddress(String addressid) throws SQLException {
		pst = connection.prepareStatement("select * from Address where addressid=?");
		pst.setString(1, addressid);
		rs = null;
		rs = pst.executeQuery();
		if (rs.next()) {
			addressDTO = null;
			addressDTO = new AddressDTO();
			addressDTO.setAddressid(rs.getString(1));
			addressDTO.setRetailerId(rs.getString(2));
			addressDTO.setBuidingNo(rs.getString(3));
			addressDTO.setCity(rs.getString(4));
			addressDTO.setState(rs.getString(5));
			addressDTO.setField(rs.getString(6));
			addressDTO.setZip(rs.getString(7));

		}
		return addressDTO;
	}

	@Override
	public boolean addAddress(AddressDTO addressDTO1) throws SQLException {
		addressDTO = SearchAddress(addressDTO1.getAddressid());
		if (addressDTO == null) {
			System.out.println("address not found can be added");
			pst = null;
			pst = connection.prepareStatement("insert into Address values(?,?,?,?,?,?,?)");
			pst.setString(1, addressDTO1.getAddressid());
			pst.setString(2, addressDTO1.getRetailerId());
			pst.setString(3, addressDTO1.getBuidingNo());
			pst.setString(4, addressDTO1.getCity());
			pst.setString(5, addressDTO1.getState());
			pst.setString(6, addressDTO1.getField());
			pst.setString(7, addressDTO1.getZip());
			int res = pst.executeUpdate();
			if (res == 1)
				return true;
			else
				return false;
		}
		return false;
	}

	@Override
	public boolean deleteAddress(String addressid) throws SQLException {
		Scanner sc = new Scanner(System.in);
		addressDTO = SearchAddress(addressid);
		if (addressDTO != null) {
			pst = null;
			pst = connection.prepareStatement("DELETE FROM Address WHERE AddressID=?");
			pst.setString(1, addressDTO.getAddressid());
			int res = pst.executeUpdate();
			if (res == 1) {
				System.out.println("delete from database y/n");
				String ch = sc.next();
				if (ch.equalsIgnoreCase("y")) {
					connection.commit();
					return true;
				} else {
					connection.rollback();
					return false;
				}
			}

		}

		return false;
	}

	@Override
	public boolean updateAddress(String id, String no, String ci, String st, String f, String zp) throws SQLException {
		Scanner sc = new Scanner(System.in);
		addressDTO = SearchAddress(id);
		if (addressDTO != null) {
			pst = connection.prepareStatement(
					"UPDATE Address SET buildingNo=? ,city=? , state=? , field=? , zip=? where addressid=?");
			pst.setString(1, no);
			pst.setString(2, ci);
			pst.setString(3, st);
			pst.setString(4, f);
			pst.setString(5, zp);
			pst.setString(6, id);
			int res = pst.executeUpdate();
			if (res == 1) {
				System.out.println("update into database y/n");
				String ch = sc.next();
				if (ch.equalsIgnoreCase("y")) {
					connection.commit();
					return true;
				} else {
					connection.rollback();
					return false;
				}
			}

		}
		return false;
	}

}
