package com.demo.ticketManagement.ticketManagement.service;


import com.demo.ticketManagement.ticketManagement.model.Ticket;

import java.util.List;

public interface TicketService {


    Ticket saveTicket(Ticket ticket);

    Ticket editTicket(Ticket ticket);

    List<Ticket> getUserTicket(String userName,String category);

    Ticket approveTicket(String Username, String ticketName, String status );

    List<Ticket> getAllTicketOfUser(String userName);

    Ticket getTicketByID(String id);

    void deleteTicket(String id);

}
