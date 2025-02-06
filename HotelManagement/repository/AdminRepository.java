package com.cts.HotelManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.HotelManagement.entity.Admin;

@Repository
	public interface AdminRepository extends JpaRepository<Admin, String> {
	    Optional<Admin> findByAdminId(String adminId);

}
