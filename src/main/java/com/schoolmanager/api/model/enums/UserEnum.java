package com.schoolmanager.api.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserEnum {
    PROFESSOR(),
    STUDENT(),
    SECRETARY(),
    ADMIN();
}
