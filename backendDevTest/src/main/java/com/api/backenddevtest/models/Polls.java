package com.api.backenddevtest.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Polls {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotEmpty
    @Pattern(regexp = "/[A-Za-z0-9]+/g")
    private String name;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "polls"
    )
    //@JoinColumn(
    //        name = "nameOptional",
    //        referencedColumnName = "name"
    //)
    private List<Options> options = new ArrayList<Options>();
}
