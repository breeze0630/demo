package com.example.springboot.autoconfig.web.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author liu
 * @since 2020-11-13
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("t_admin_user")
public class AdminUser extends Model<AdminUser> {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 登录账号
     */
      private String username;

      /**
     * 登录密码
     */
      private String password;

      /**
     * 创建时间
     */
      private LocalDateTime createDt;

      /**
     * 修改时间
     */
      private LocalDateTime updateDt;

      /**
     * 昵称
     */
      @TableField("nickName")
    private String nickname;

      /**
     * token
     */
      private String token;

      /**
     * 手机号
     */
      private String mobile;


    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
