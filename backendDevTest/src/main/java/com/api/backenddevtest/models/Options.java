package com.api.backenddevtest.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Options {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotEmpty(message = "Yout name is empty")
    private String name;

    @Column
    @PositiveOrZero
    private int votes;

    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Polls polls;

}
