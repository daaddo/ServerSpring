package it.cascella.redisBridge.entities;

import jakarta.persistence.*;

public class Task {
    @Id
    private Long id;

    private String text;

    private String description;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

}
