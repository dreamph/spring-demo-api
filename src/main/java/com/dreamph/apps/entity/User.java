package com.dreamph.apps.entity;

import com.dreamph.apps.entity.base.Base;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;


@Data
@Table("app_user")
public class User extends Base {

    @Id
    @Column("id")
    private String id;

    @Column("id_card_no")
    private String idCardNo;

    @Column("login_name")
    private String loginName;

    @Column("login_password")
    private String loginPassword;

    @Column("first_name")
    private String firstName;

    @Column("last_name")
    private String lastName;

    @Column("create_by")
    private String createBy;

    @Column("create_date")
    private Date createDate;

    @Column("change_by")
    private String changeBy;

    @Column("change_date")
    private Date changeDate;

    @Override
    public String getId() {
        return id;
    }
}