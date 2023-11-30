package com.example.reviewfilm.model.entities;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;
import java.util.UUID;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {
    @Id
    private ObjectId id;
    private String rvId;
    private String body;
    private int favourite;
    @DocumentReference()
    private List<Review> reviewIds;
}
