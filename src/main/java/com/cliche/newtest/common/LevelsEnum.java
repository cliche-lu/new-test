package com.cliche.newtest.common;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 字典编码 `energy_type`
 * 物流-驱动轴数
 */
@Getter
public enum LevelsEnum implements CodeEnum {
    ONE("1", "18k-10k"),
    TWO("2", "10k-5k"),
    THREE("3", "5k-1k"),
    FOUR("4", "1k-3d"),
    FIVE("5", "3d-5d"),
    SIX("6", "5d-8d"),
    SEVEN("7", "8d-9d")
    ;

    @EnumValue//标记数据库存的值是code
    private final String code;
    private final String msg;

    LevelsEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
