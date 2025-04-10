package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.MediaDTO;
import com.example.backofficepro.model.Media;
import java.util.List;
import java.util.stream.Collectors;

public class MediaMapper {

    public static MediaDTO toDTO(Media media) {
        if (media == null) {
            return null;
        }
        return new MediaDTO(
                media.getId(),
                media.getTitle(),
                media.getRating(),
                media.getDescription(),
                media.getPhotoUrl(),
                media.getReleaseDate()
        );
    }

    public static Media toEntity(MediaDTO mediaDTO) {
        if (mediaDTO == null) {
            return null;
        }
        return new Media(
                mediaDTO.getId(),
                mediaDTO.getTitle(),
                mediaDTO.getRating(),
                mediaDTO.getDescription(),
                mediaDTO.getPhotoUrl(),
                mediaDTO.getReleaseDate()
        );
    }

    public static List<MediaDTO> toDTOList(List<Media> medias) {
        return medias.stream()
                .map(MediaMapper::toDTO)
                .collect(Collectors.toList());
    }
}
