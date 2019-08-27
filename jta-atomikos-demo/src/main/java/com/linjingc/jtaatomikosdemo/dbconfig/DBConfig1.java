package com.linjingc.jtaatomikosdemo.dbconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "mysql.datasource.test1")
public class DBConfig1 {
	private String url;
	private String username;
	private String password;
}
