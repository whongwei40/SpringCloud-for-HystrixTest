package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author dongjunzi
 * @DATE 2022/4/6 14:28
 */
@AllArgsConstructor
@NoArgsConstructor
public enum RequestEnum {

    SUCCESS_CODE(2000),

    FILED_CODE(2001);

    @Getter
    Integer Code;

}
