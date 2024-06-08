package com.example.spring_security.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientHttpConfig {
	
//	@Bean(name="simpleRestTemplate")
//	@Primary
//	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
//
//		ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(null)
//	    RestTemplate template = restTemplateBuilder.requestFactory(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))
//	                                                .interceptors(logRestRequestInterceptor) //This is your custom interceptor bean
//	                                                .messageConverters(new MappingJackson2HttpMessageConverter())
//	                                                .build();
//	    return template;

	 @Bean
	   public RestTemplate restTemplateBean() {
	        return new RestTemplate();
	    }

	}


