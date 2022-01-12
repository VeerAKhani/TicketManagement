package com.demo.ticketManagement.ticketManagement.repository;

import com.demo.ticketManagement.ticketManagement.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByName(String name);
}
