package com.demo.ticketManagement.ticketManagement.controller;

import com.demo.ticketManagement.ticketManagement.enums.TicketStatusType;
import com.demo.ticketManagement.ticketManagement.model.Ticket;
import com.demo.ticketManagement.ticketManagement.repository.TicketRepository;
import com.demo.ticketManagement.ticketManagement.service.TicketService;
import com.demo.ticketManagement.ticketManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sun.util.resources.cldr.kea.TimeZoneNames_kea;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/approval", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApprovalController {


    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TicketService ticketService;


    @GetMapping("/getList")
    public List<Ticket> getMessage(){
        List<Ticket> tickets = ticketRepository.findAll();
        tickets =  tickets.stream().filter(ticket -> ticket.getStatus().equals(TicketStatusType.PENDING.name())).collect(Collectors.toList());
        return tickets;
    }

   @PutMapping("/approveTicket")
    public Ticket approveTicket(@RequestPart String Username , @RequestPart String TicketName, @RequestPart String status){
        return ticketService.approveTicket(Username,TicketName,status);
    }



}
