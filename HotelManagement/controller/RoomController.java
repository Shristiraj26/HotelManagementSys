package com.cts.HotelManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cts.HotelManagement.entity.Room;
import com.cts.HotelManagement.service.RoomService;

@Controller
@RequestMapping("/admin")
public class RoomController {

    @Autowired
    private RoomService roomService;

    // Load Manage Rooms Page
    @GetMapping("/manageRooms")
    public String showManageRoomsPage(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "Admin/manageRoom";  // Ensure the file is inside templates/Admin/
    }

    // Add New Room
    @PostMapping("/addRoom")
    public String addRoom(@RequestParam String roomNumber,
                          @RequestParam String roomType,
                          @RequestParam String bedType,
                          @RequestParam double price) {
        Room newRoom = new Room(roomNumber, roomType, bedType, price, "Available");
        roomService.saveRoom(newRoom);
        return "redirect:/admin/manageRooms"; // Refresh Page
    }

    // Delete Room
    @PostMapping("/deleteRoom/{id}")
    public String deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return "redirect:/admin/manageRooms";
    }
    
    //Edit Room
    @PostMapping("/updateRoom")
    public String updateRoom(@RequestParam Long id,
                             @RequestParam String roomNumber,
                             @RequestParam String roomType,
                             @RequestParam String bedType,
                             @RequestParam double price,
                             @RequestParam String status) {
        Room room = roomService.getRoomById(id);
        if (room != null) {
            room.setRoomNumber(roomNumber);
            room.setRoomType(roomType);
            room.setBedType(bedType);
            room.setPrice(price);
            room.setStatus(status);
            roomService.saveRoom(room);
        }
        return "redirect:/admin/manageRooms";
    }
}