package com.cts.HotelManagement.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cts.HotelManagement.service.AdminService;
import com.cts.HotelManagement.service.CustomerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/admin")
public class AdminController {
 
    @Autowired
    private AdminService adminService;
    
    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/home")
    public String showAdminDashboard(Model model, HttpServletResponse response) {
        System.out.println("Fetching checked-in customers..."); // Debugging
        model.addAttribute("customers", customerService.getCheckedInCustomers());

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        
        System.out.println("Customers fetched: " + customerService.getCheckedInCustomers().size()); // Debugging
        return "Admin/home";
    }

 
    
 
    // Handle Admin Login Authentication
    @PostMapping("/authenticate")
    public String authenticateAdmin(@RequestParam String admin_id,
                                    @RequestParam String password,
                                    Model model) {
        boolean isAuthenticated = adminService.authenticateAdmin(admin_id, password);
     
        if (isAuthenticated) {
            return "redirect:/admin/home"; // Redirect to Admin Dashboard on success
        } else {
            model.addAttribute("error", "Invalid Admin ID or Password");
            return "adminLogin"; // Reload login page with error message
        }
    }
 
 // Load Customer Check-in Page
    @GetMapping("/checkIn")
    public String showCustomerCheckInPage() {
        return "Admin/checkIn"; // Redirect to checkIn.html
    }
    
 // Redirect to Admin Login Page
    @GetMapping("/login")
    public String showLoginPage(HttpServletResponse response,
                                @RequestParam(value = "error", required = false) String error,
                                Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid Credentials");
        }
       
     // Prevent caching login page
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        return "adminLogin";  // Matches Thymeleaf template name
    }
    
 // Handle Customer Check-in
    @PostMapping("/checkInCustomer")
    public String checkInCustomer(@RequestParam String name,
                                  @RequestParam String mobile,
                                  @RequestParam String email,
                                  @RequestParam LocalDate checkInDate,
                                  @RequestParam String roomType,
                                  @RequestParam String bedType,
    							  @RequestParam String roomNumber){
        customerService.checkInCustomer(name, mobile, email, checkInDate, roomType, bedType, roomNumber);
        return "redirect:/admin/home"; // Redirect to refresh page
    }
    
 // Handle Customer Checkout
    @PostMapping("/checkOut/{id}")
    public String checkOutCustomer(@PathVariable Long id) {
        customerService.checkOutCustomer(id);
        return "redirect:/admin/home";
    }
    
    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        session.invalidate(); // Clears the session
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        return "redirect:/admin/adminlogin"; // Redirects to login page
    }
}
