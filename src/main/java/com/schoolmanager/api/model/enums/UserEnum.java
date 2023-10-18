package com.schoolmanager.api.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserEnum {
    PROFESSOR("Professor"),
    STUDENT("Student"),
    SECRETARY("Secretary");
    String nivelAcesso;
}
