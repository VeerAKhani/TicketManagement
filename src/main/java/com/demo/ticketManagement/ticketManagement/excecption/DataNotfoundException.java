package com.demo.ticketManagement.ticketManagement.excecption;

public class DataNotfoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public String error;

    public DataNotfoundException(String error){
        this.error = error;
    }
}
