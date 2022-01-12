package com.demo.ticketManagement.ticketManagement.controller;

import com.demo.ticketManagement.ticketManagement.model.Ticket;
import com.demo.ticketManagement.ticketManagement.service.TicketService;
import com.demo.ticketManagement.ticketManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/ticket", produces = MediaType.APPLICATION_JSON_VALUE)
public class TicketController {


    @Autowired
    TicketService ticketService;


    // Create New ticket
    @PostMapping("/create")
    public Ticket saveTicket(@RequestBody Ticket ticket){
        return ticketService.saveTicket(ticket);
    }

    // Edit ticket
    @PutMapping("/edit")
    public Ticket editTicket(@RequestBody Ticket ticket){
        return ticketService.editTicket(ticket);
    }

    // Get All Tickets For the specfied user Name and Category
    @GetMapping("/getuserticket/{user-name}")
    public List<Ticket> getTicketList(@PathVariable(value = "user-name") String username,@RequestPart String category){
        return  ticketService.getUserTicket(username, category);
    }

    // Get All Tickets For the specfied user Name
    @GetMapping("/getAllTicket/{user-name}")
    public List<Ticket> getAllList(@PathVariable(value = "user-name") String username){
        return  ticketService.getAllTicketOfUser(username);
    }

    // Get Ticket For the specfied Id
    @GetMapping("/getTicketById/{id}")
    public Ticket getTicketByID(@PathVariable(value = "id") String id){
        return  ticketService.getTicketByID(id);
    }

    // Delete ticket
    @DeleteMapping("/delete/{id}")
    public String deleteTicketByID(@PathVariable(value = "id") String id){
          ticketService.deleteTicket(id);
        return "Ticket Deleted";
    }


}
