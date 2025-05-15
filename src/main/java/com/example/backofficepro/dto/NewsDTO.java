package com.example.backofficepro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsDTO {

    private Long id;
    private String title;
    private String content;
    private LocalDate publishDate;
    private String category;
    private String author;
}
