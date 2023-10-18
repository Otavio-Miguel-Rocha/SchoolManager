package com.schoolmanager.api.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserEnum {
    PROFESSOR("Professor"), //0
    STUDENT("Student"), //1
    SECRETARY("Secretary"); //2
    String nivelAcesso;
}
