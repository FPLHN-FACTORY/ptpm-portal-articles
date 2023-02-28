package com.articlesproject.entity.a;

import com.articlesproject.entity.base.PrimaryEntity;
import com.articlesproject.infrastructure.constant.EntityProperties;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Nationalized;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Data
@ToString
@Table(name = "comments")
public class Comments extends PrimaryEntity{

    @Nationalized
    @Column(length = EntityProperties.LENGTH_DESCRIPTION, nullable = false)
    private String noiDung;

    @Nationalized
    @Column(length = EntityProperties.LENGTH_CODE, nullable = false)
    private Integer kieu;

    @Column(nullable = false)
    private Long thoiGianComment;

    private String relay;

    @Column(length = EntityProperties.LENGTH_ID)
    private String usersId;

    @Column(length = EntityProperties.LENGTH_ID)
    private String baiVietId;
}