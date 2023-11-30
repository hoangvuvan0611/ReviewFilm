package com.example.reviewfilm.model.entities;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    private ObjectId id;
    private String uId;
    private String userName;
    private String fullName;
    private String email;
    private String avt;
    private int age;
    private String password;
}
