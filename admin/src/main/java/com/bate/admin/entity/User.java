package com.bate.admin.entity;

import com.bate.admin.ext.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: lh
 * @date: 2021/3/29
 */

@Setter
@Getter
public class User extends DataEntity<User> {

    private String  userName;

    private String password;

    @JsonIgnore
    private String token;

    private int sex;

    private String realname;

    private String idCode;

    private String mobile;

    private String avatar;

    private String companyId;

    private String department;

    private List<Role> roles;

    private List<Menu> menus;

    public User(){
    }
    public User(String id){
        super(id);
    }
}
