/*
 * Copyright 2017. the original author is eumji, email: eumji025@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.eumji.fallback;

import com.eumji.fallback.controller.MyFallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class SpringCloudNetflixZuulFallbackClientApplication {


	@Bean
	public MyFallbackProvider myFallbackProvider(){
		return new MyFallbackProvider();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudNetflixZuulFallbackClientApplication.class, args);
	}
}
