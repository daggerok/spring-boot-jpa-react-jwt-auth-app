package com.example.polls.payload;

import lombok.Value;

@Value
public class ApiResponse {
    Boolean success;
    String message;
}
