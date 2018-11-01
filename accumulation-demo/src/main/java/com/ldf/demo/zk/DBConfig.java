package com.ldf.demo.zk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ldf on 2018/10/31.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DBConfig {
    private String url;
    private String driver;
    private String username;
    private String password;
}
