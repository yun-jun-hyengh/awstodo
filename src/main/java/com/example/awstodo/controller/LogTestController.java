package com.example.awstodo.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTestController {
	
	@GetMapping("/api/log/test")
	public Map<String, Object> logJsonTest() {
		Map<String, Object> logData = new HashMap<>();
        logData.put("timestamp", LocalDateTime.now().toString());
        logData.put("event", "USER_ACCESS");
        logData.put("user_id", "test_user_01");
        logData.put("client_ip", "127.0.0.1");
        logData.put("status", "SUCCESS");
        logData.put("message", "사용자 페이지 접속 로그 테스트");

        // 2. 터미널(콘솔)에 바로 찍기
        System.out.println("=======================================");
        System.out.println("LOG_CHECK: " + logData.toString());
        System.out.println("=======================================");

        // 3. 브라우저로 JSON 데이터 반환
        return logData;
	}
	
	/***
	 * <?xml version="1.0" encoding="UTF-8"?>
<configuration scan="true" scanPeriod="40 seconds">

    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <appender name="SYSLOG" class="ch.qos.logback.classic.net.SyslogAppender">
        <syslogHost>[베스천 프라이빗 ip]</syslogHost> <port>514</port>
        <facility>USER</facility>
        <suffixPattern>%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n</suffixPattern>
    </appender>

    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>/home/ubuntu/logs/user-page.log</file>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>/home/ubuntu/logs/user-page.%d{yyyy-MM-dd}.log</fileNamePattern>
            <maxHistory>30</maxHistory>
        </rollingPolicy>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <root level="INFO">
        <appender-ref ref="CONSOLE" />
        <appender-ref ref="FILE" />
        <appender-ref ref="SYSLOG" /> </root>

</configuration>
	 */
}
