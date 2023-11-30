package com.example.reviewfilm.requests;

import lombok.Data;

@Data
public class DeleteReviewRequest {
    private String rvId;
    private String imdbId;
}
