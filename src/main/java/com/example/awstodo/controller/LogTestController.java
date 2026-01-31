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
}
