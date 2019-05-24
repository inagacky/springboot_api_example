package com.inagacky.api_sample_app.domain.entity.sample;

import com.inagacky.api_sample_app.domain.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public abstract class BaseSampleEntity extends BaseEntity {

    @NotNull
    private Timestamp createdAt;

    @NotNull
    private Timestamp updatedAt;
}
