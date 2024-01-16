package jpabook.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter @Setter
@MappedSuperclass
public abstract class BaseEntity {

    private LocalDateTime createdBy;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedBy;
    private LocalDateTime lastModifiedDate;
}
