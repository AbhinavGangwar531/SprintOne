package com.capgemini.go.service;
import java.sql.SQLException;
import com.capgemini.go.dto.*;
public interface AddressService {
	public void viewAllAddress() throws SQLException;
	public void addAddress() throws SQLException;
	public boolean updateAddress()throws SQLException;
	public void deleteAddress()throws SQLException;

}
