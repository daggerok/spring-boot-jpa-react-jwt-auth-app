package com.example.polls.model;

import lombok.Value;

@Value
public class ChoiceVoteCount {
  Long choiceId, voteCount;
}
