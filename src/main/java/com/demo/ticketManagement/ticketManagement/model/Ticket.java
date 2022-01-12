package com.demo.ticketManagement.ticketManagement.model;

import com.demo.ticketManagement.ticketManagement.enums.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "ticket")
public class Ticket {

    @Id
    private String id;
    @Field(name = "user_Name")
    private String userName;
    @Field(name = "ticket_name")
    private String ticketName;
    @Field(name = "description")
    private String description;
    @Field("ticket_category")
    private String ticketCategory;
    private String status;
}
