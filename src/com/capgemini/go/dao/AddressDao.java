package com.capgemini.go.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.capgemini.go.dto.AddressDTO;
public interface AddressDao {
	
	public HashMap<String,AddressDTO> viewAllAddress() throws SQLException;
	public boolean addAddress(AddressDTO addressDTO)throws SQLException;
	public boolean updateAddress(String id,String no,String ci,String st,String f,String zp) throws SQLException;
	public boolean deleteAddress(String addressid)throws SQLException;
	public AddressDTO SearchAddress(String addressid)throws SQLException;
}
