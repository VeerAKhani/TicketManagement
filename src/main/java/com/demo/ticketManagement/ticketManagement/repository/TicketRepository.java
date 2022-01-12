package com.demo.ticketManagement.ticketManagement.repository;

import com.demo.ticketManagement.ticketManagement.model.Ticket;
import com.demo.ticketManagement.ticketManagement.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, ObjectId> {

    @Query(value = "{user_Name : ?0, ticket_category: ?1}")
    List<Ticket> getTicketByNameAndCategory(String userName, String ticketCategory);

    @Query(value = "{user_Name : ?0, ticket_name: ?1}")
    Ticket getTicketByUserAndTicketName(String userName, String ticketName);

    @Query(value = "{user_Name : ?0}")
    List<Ticket> getAllTicketOfUser(String userName);
}
