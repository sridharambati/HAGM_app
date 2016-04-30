package com.skysol.grievance.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
@ComponentScan(basePackages="com.skysol.grievance")
public class MongodbConfiguration {
	final static Logger logger = Logger.getLogger(MongodbConfiguration.class);

	private MongoTemplate mongoTemplate;
	public @Bean
	MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new MongoClient(), "hagmdb");
	}

	public @Bean
	MongoTemplate mongoTemplate() throws Exception {
		
		mongoTemplate = new MongoTemplate(mongoDbFactory());
				
		return mongoTemplate;
		
	}
	
}
