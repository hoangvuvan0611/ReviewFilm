package com.example.reviewfilm.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDTO {
    private ObjectId id;
    private String rvId;
    private String body;
    private int favourite;
}
