package com.articlesproject.entity;

import com.articlesproject.entity.base.PrimaryEntity;
import com.articlesproject.infrastructure.constant.EntityProperties;
import lombok.*;
import org.hibernate.annotations.Nationalized;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@ToString
@Table(name = "articles")
public class Articles extends PrimaryEntity {

    @Column( nullable = false, length = EntityProperties.LENGTH_NoiDung )
    private String fileName;

    @Column( nullable = false, length = EntityProperties.LENGTH_NoiDung )
    private String title;

    @Column( nullable = false, length = EntityProperties.LENGTH_NoiDung )
    private String content;

    @Column( nullable = false)
    private String img;

    @Column(nullable = false)
    private Integer status;

    @Column()
    private Long lastModifiedDate;

    @Column(nullable = false)
    private Integer tym;

    @Nationalized
    @Column(length = EntityProperties.LENGTH_DESCRIPTION)
    private String review;

    @Column()
    private Long browseDate;

    @Column(length = EntityProperties.LENGTH_ID)
    private String categoryId;

    @Column(length = EntityProperties.LENGTH_ID)
    private String usersId;

}

