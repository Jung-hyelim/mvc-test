package com.test.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer user_id;
    private String login_id;
    private String name;
    private int age;
}
