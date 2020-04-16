package com.example.polls.model;

import com.example.polls.model.audit.DateAudit;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(
    name = "votes",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "poll_id",
            "user_id"
        })
    }
)
@NoArgsConstructor
public class Vote extends DateAudit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "poll_id", nullable = false)
  private Poll poll;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "choice_id", nullable = false)
  private Choice choice;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;
}
