package com.cliche.newtest.common;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 字典编码 `energy_type`
 * 物流-驱动轴数
 */
@Getter
public enum DataTypeEnum implements CodeEnum {
    ONE("1", "棋谱"),
    TWO("2", "其他")
    ;

    @EnumValue//标记数据库存的值是code
    private final String code;
    private final String msg;

    DataTypeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
