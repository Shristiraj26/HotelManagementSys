package com.cts.HotelManagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.HotelManagement.entity.Admin;
import com.cts.HotelManagement.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
    private AdminRepository adminRepository;
 
    public boolean authenticateAdmin(String adminId, String password) {
        Optional<Admin> admin = adminRepository.findByAdminId(adminId);
        return admin.isPresent() && admin.get().getPassword().equals(password);
    }

}
