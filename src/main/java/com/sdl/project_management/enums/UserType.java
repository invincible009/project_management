package com.sdl.project_management.enums;

import java.util.Arrays;
import java.util.List;

public enum UserType {
    ADMIN("ADM"),
    OPERATIONS("OPS"),
    RETAIL("RET"),
    CORPORATE("CORP");

    UserType(String description){
    }

    public static List<UserType> getUseryTypes(){
        return Arrays.asList(UserType.values());
    }

}
