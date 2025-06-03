package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer user_id;
    private String login_id;
    private String password;
    private String name;
    private String delete_flg;
    private Date date_created;
    private Date date_changed;
}
