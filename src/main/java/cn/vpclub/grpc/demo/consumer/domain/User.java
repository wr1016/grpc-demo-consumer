package cn.vpclub.grpc.demo.consumer.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by WangRui on 2017/9/21.
 */
@Getter
@Setter
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    private String id;
    /**
     * 用户名称
     */
    private String username;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 创建日期
     */
    private Long createDate;
    /**
     * 更新日期
     */
    private Long updateDate;
    /**
     * 删除标识：0 未删除，1 已删除
     */
    private Integer delFlag = 0;
    /**
     * 备注
     */
    private String remark;
}
