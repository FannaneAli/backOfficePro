package com.example.backofficepro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediaThemeAssociationDTO {

    private Long id;
    private MediaDTO media;
    private ThemeDTO theme;
}
