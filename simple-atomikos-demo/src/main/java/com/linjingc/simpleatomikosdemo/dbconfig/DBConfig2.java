package com.linjingc.simpleatomikosdemo.dbconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "mysql.datasource.test2")
public class DBConfig2 {
	private String url;
	private String username;
	private String password;
}
