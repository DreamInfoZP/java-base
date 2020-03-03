package com.zp.annottation;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * <p></p>
 *
 * @author zhoupeng
 * @date Filter.java v1.0  2019/12/19 8:48 下午
 */
@Data
@Table("t_filter")
public class Filter {

    @Column("id")
    private Integer id;

    @Column("user_name")
    private String userName;

    @Column("nick_name")
    private String nickName;

    @Column("age")
    private Integer age;

    @Column("city")
    private String city;

    @Column("email")
    private String email;
    private String mobile;
}
