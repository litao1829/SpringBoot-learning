package com.example.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "t_comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Discuss {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String author;
    private String content;

    @Column(name = "a_id")
    private Integer AId;
}
