package com.tns.auth.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "auth")
public record AuthContactInfoDto(String description, Map<String,String> contactDetails, List<String> onCallSupport) {
}
