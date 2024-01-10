package jpabook.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter @Setter
@MappedSuperclass
public abstract class BaseEntity {

    private String createdBy;
    private String createdDate;
    private String lastModifiedBy;
    private String lastModifiedDate;
}
