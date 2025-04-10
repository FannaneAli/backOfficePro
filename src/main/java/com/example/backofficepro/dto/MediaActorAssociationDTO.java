package com.example.backofficepro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediaActorAssociationDTO {

    private Long id;
    private ActorDTO actor;
    private MediaDTO media;
}
