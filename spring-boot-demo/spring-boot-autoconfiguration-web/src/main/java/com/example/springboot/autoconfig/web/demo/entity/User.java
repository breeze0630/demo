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
 * 用户表
 * </p>
 *
 * @author liu
 * @since 2020-11-13
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("t_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

      /**
     * 主键
     */
        @TableId(value = "user_id", type = IdType.AUTO)
      private Integer userId;

      /**
     * 用户名
     */
      private String userName;

      /**
     * 手机号
     */
      private String phone;

      /**
     * 地区
     */
      private Integer region;

      /**
     * 密码
     */
      private String password;

      /**
     * 1：C端用户 2：代理商
     */
      private Integer userType;

      /**
     * 微信号
     */
      private String wxNo;

      /**
     * 微信openId
     */
      @TableField("wx_openId")
    private String wxOpenid;

    private LocalDateTime createDt;

    private LocalDateTime updateDt;

      /**
     * 推荐人
     */
      private String recommend;

      /**
     * 微信昵称
     */
      private String wxName;

      /**
     * token
     */
      private String token;

      /**
     * 负责人
     */
      private String fzName;

      /**
     * 身份证正面照片
     */
      private String idCardFace;

      /**
     * 身份证反面照片
     */
      private String idCardBack;

      /**
     * 驾驶证
     */
      private String drivingLicenceFace;

      /**
     * 驾驶证
     */
      private String drivingLicenceBack;

    private String sessionKey;


    @Override
    protected Serializable pkVal() {
          return this.userId;
      }

}
