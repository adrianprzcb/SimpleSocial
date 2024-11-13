package com.adrian.SimpleSocial.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne // Many messages can be posted by one user
    private User user;
}