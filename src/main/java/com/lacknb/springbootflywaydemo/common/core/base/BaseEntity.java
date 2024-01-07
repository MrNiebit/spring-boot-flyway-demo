package com.lacknb.springbootflywaydemo.common.core.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gitsilence
 * @date 2024-01-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseEntity<T extends Model<?>> extends Model<T> {

    /**
     * 创建时间
     */
    @TableField("gmt_create")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @TableField("gmt_modify")
    private Date gmtModify;

}
