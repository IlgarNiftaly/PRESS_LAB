package com.example.press_lab.mappers;

import com.example.press_lab.entity.News;
import com.example.press_lab.request.news.NewsCreateRequest;
import com.example.press_lab.request.news.NewsUpdateRequest;
import com.example.press_lab.response.news.NewsCardResponse;
import com.example.press_lab.response.news.NewsCreateResponse;
import com.example.press_lab.response.news.NewsReadResponse;
import com.example.press_lab.response.news.NewsUpdateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.io.IOException;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface NewsMapper {

    @Mapping(target = "image", source = "imageBytes")
    News mapRequestToEntity(NewsCreateRequest newsCreateRequest) throws IOException;

//    default byte[] map(MultipartFile image) throws IOException {
//        return image != null ? image.getBytes() : null;
//    }

    NewsCreateResponse mapCreateToResponse(News news);

    NewsReadResponse mapReadToResponse(News news);

    NewsCardResponse mapReadToCardResponse(News news);

    NewsUpdateResponse mapUpdateToResponse(News news);

    News updateNewsToNewsUpdateResponse(NewsUpdateRequest updateRequest, @MappingTarget News news);

}
