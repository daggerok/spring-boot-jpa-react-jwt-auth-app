package com.example.polls.payload;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class VoteRequest {
    @NotNull
    private Long choiceId;
}

