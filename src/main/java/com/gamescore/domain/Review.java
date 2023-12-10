package com.gamescore.domain;

import org.bson.types.ObjectId;

import java.time.LocalDate;

public class Review {

    private String tittle;
    private String description;
    private long num_start;
    private LocalDate date;

    private ObjectId user_id;

}
