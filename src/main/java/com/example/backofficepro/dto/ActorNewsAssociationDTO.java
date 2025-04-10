package com.example.backofficepro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorNewsAssociationDTO {

    private Long id;
    private ActorDTO actor;
    private NewsDTO news;
}
