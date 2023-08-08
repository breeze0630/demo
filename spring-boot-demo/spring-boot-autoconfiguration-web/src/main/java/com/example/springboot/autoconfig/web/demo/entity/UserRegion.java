package com.example.springboot.autoconfig.web.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户-地区关联
 * </p>
 *
 * @author liu
 * @since 2020-11-13
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("t_user_region")
public class UserRegion extends Model<UserRegion> {

    private static final long serialVersionUID = 1L;

      /**
     * 自增主键
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 用户id
     */
      private Integer userId;

      /**
     * 地区id
     */
      private Integer region;

      /**
     * 创建时间
     */
      private LocalDateTime createDt;

    private LocalDateTime updateDt;


    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
