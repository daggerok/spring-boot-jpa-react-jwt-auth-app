package com.example.polls.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class ChoiceRequest {

    @NotBlank
    @Size(max = 40)
    private String text;
}
