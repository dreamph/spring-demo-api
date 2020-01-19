package com.dreamph.apps.entity.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Base implements Persistable<String> {

    @JsonIgnore
    @Transient
    private boolean newEntity = true;

    public abstract String getId();

    @JsonIgnore
    @Override
    public boolean isNew() {
        return newEntity;
    }
}