package com.boot;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;

@Configuration
public class DBConfig {
	
	@Bean
	public Datastore getDataStore() {
		DatastoreOptions options;
		Datastore service = null;
		try {
			options = DatastoreOptions.newBuilder().setProjectId("greengst-4b3ea").setCredentials(GoogleCredentials.fromStream(new FileInputStream(getClass().getResource("/keys/GreenGST-1d4081bc91b8.json").getFile()))).build();
			service = options.getService();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return service;
	}

}
