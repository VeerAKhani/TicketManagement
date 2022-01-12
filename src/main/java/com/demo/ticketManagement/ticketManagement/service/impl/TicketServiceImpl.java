package com.demo.ticketManagement.ticketManagement.service.impl;

import com.demo.ticketManagement.ticketManagement.enums.CategoryType;
import com.demo.ticketManagement.ticketManagement.enums.TicketStatusType;
import com.demo.ticketManagement.ticketManagement.excecption.DataNotfoundException;
import com.demo.ticketManagement.ticketManagement.model.Ticket;
import com.demo.ticketManagement.ticketManagement.model.User;
import com.demo.ticketManagement.ticketManagement.repository.TicketRepository;
import com.demo.ticketManagement.ticketManagement.repository.UserRepository;
import com.demo.ticketManagement.ticketManagement.service.TicketService;
import org.apache.commons.lang3.EnumUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;


@Service
public class TicketServiceImpl implements TicketService {


    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Ticket saveTicket(Ticket ticket) {
        User user = userRepository.findByName(ticket.getUserName());
        if(ObjectUtils.isEmpty(user)){
            throw new DataNotfoundException("User");
        }
        ticket.setStatus(TicketStatusType.PENDING.name());

        if(!EnumUtils.isValidEnum(CategoryType.class, ticket.getTicketCategory())){
            throw new DataNotfoundException("category");
        }
        ticketRepository.save(ticket);
        return ticket;
      //  }
    }

    @Override
    public Ticket editTicket(Ticket ticket) {

        Optional<Ticket> ticketOpt = ticketRepository.findById(new ObjectId(ticket.getId()));
        if(!ticketOpt.isPresent()){
            throw new DataNotfoundException("ticket");
        }
        if(!EnumUtils.isValidEnum(CategoryType.class, ticket.getTicketCategory())){
            throw new DataNotfoundException("category");
        }
        Ticket ticketData = ticketOpt.get();
        ticketData.setTicketName(ticket.getTicketName());
        ticketData.setDescription(ticket.getDescription());
        ticketData.setUserName(ticket.getUserName());
        ticketData.setTicketCategory(ticket.getTicketCategory());
        return ticketRepository.save(ticketData);
    }

    @Override
    public List<Ticket> getUserTicket(String userName,String category) {
        return ticketRepository.getTicketByNameAndCategory(userName,category);
    }

    @Override
    public List<Ticket> getAllTicketOfUser(String userName) {
        return ticketRepository.getAllTicketOfUser(userName);
    }

    @Override
    public Ticket getTicketByID(String id) {
        Optional<Ticket> ticketOpt = ticketRepository.findById(new ObjectId(id));
        if(!ticketOpt.isPresent()){
            throw new DataNotfoundException("ticket");
        }
        return ticketOpt.get();
    }

    @Override
    public void deleteTicket(String id) {

        Optional<Ticket> ticketOpt = ticketRepository.findById(new ObjectId(id));
        if(!ticketOpt.isPresent()){
            throw new DataNotfoundException("ticket");
        }
        ticketRepository.delete(ticketOpt.get());
    }

    @Override
    public Ticket approveTicket(String Username, String ticketName, String status) {

        User user = userRepository.findByName(Username);
        if(ObjectUtils.isEmpty(user)){
           throw new DataNotfoundException("User");
        }
        if(!EnumUtils.isValidEnum(TicketStatusType.class, status)){
            throw new DataNotfoundException("status");
        }
        Ticket ticket = ticketRepository.getTicketByUserAndTicketName(Username,ticketName);
        if(!ObjectUtils.isEmpty(ticket)){
            ticket.setStatus(status);
            ticketRepository.save(ticket);
        }
        return ticket;
    }
}
