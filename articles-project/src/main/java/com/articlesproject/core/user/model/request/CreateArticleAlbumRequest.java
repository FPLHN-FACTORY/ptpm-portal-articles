package com.articlesproject.core.user.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateArticleAlbumRequest {

    private String articlesId;

    private String albumId;
}
