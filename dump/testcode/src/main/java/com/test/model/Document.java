package com.test.model;

import lombok.*;

import java.util.Date;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class Document {
    private Integer document_id;
    private String title;
    private String content;
    private int read_cnt;
    private Date created_time;
    private Date updated_time;
}
