package com.example.polls.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChoiceResponse {
  private long id;
  private String text;
  private long voteCount;
}
