package com.norwayyachtbrockers.dto.mapper;

import com.norwayyachtbrockers.dto.response.YachtImageResponseDto;
import com.norwayyachtbrockers.model.YachtImage;

public class YachtImageMapper {

    public static YachtImageResponseDto convertToResponseDto(YachtImage yachtImage) {
        YachtImageResponseDto dto = new YachtImageResponseDto();
        dto.setId(yachtImage.getId());
        dto.setImageKey(yachtImage.getImageKey());
        dto.setImageIndex(yachtImage.getImageIndex());
        dto.setYachtId(yachtImage.getYacht().getId());
        return dto;
    }
}
