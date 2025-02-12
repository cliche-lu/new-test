package com.example.newtest.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @TableName my_test
 */
@TableName(value ="my_test")
@Data
public class MyTest implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * json
     */
    @TableField(value = "my_json")
    private String myJson;

    /**
     * other
     */
    @TableField(value = "other")
    private String other;

    /**
     * 小数
     */
    @TableField(value = "deciale")
    private BigDecimal deciale;

    /**
     *
     */
    @TableField(value = "zz")
    private Boolean zz;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MyTest other = (MyTest) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMyJson() == null ? other.getMyJson() == null : this.getMyJson().equals(other.getMyJson()))
            && (this.getOther() == null ? other.getOther() == null : this.getOther().equals(other.getOther()))
            && (this.getDeciale() == null ? other.getDeciale() == null : this.getDeciale().equals(other.getDeciale()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMyJson() == null) ? 0 : getMyJson().hashCode());
        result = prime * result + ((getOther() == null) ? 0 : getOther().hashCode());
        result = prime * result + ((getDeciale() == null) ? 0 : getDeciale().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", my_json=").append(myJson);
        sb.append(", other=").append(other);
        sb.append(", deciale=").append(deciale);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}