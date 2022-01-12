Take a Pull of the Given Repository in your Local system 

Run The Application : TicketManagementApplication


With the Rest Point : localhost:8181/api/v1/user/Create  you can rasie a New User

With the Rest Point : localhost:8181/api/v1/ticket/create to create a new Ticket 
                      Request Body : {
                           "userName": "Veer",
                            "ticketName": "First ticket",
                        "description": "ticket Created First ",
                        "ticketCategory": "PREMIUM",
    }

With the Rest Point : localhost:8181/api/v1/ticket/edit We can edit the ticket details 

With the Rest point : localhost:8181/api/v1/ticket/getuserticket/{user-name} We can Get All Tickets For the specfied user Name and Category

With the Rest Point : localhost:8181/api/v1/ticket/getTicketById/{id} we Can Get Ticket For the specfied Id

For the Aprove Ticket 

localhost:8181/api/v1/approval/approveTicket pass the username , ticketName and Status( Apprvoed/Reject) we can perform action

To get the Pending Ticket 

localhost:8181/api/v1/approval/getList will provide a list of pending tickets
