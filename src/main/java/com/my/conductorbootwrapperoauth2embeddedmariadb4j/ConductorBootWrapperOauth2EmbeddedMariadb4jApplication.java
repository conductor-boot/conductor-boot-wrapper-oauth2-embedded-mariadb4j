package com.my.conductorbootwrapperoauth2embeddedmariadb4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.elasticsearch.rest.RestClientAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.event.EventListener;

import com.my.conductorbootwrapperoauth2embeddedmariadb4j.conductor.runner.thread.ConductorRunnerThreadProvider;
import com.my.conductorbootwrapperoauth2embeddedmariadb4j.environment.config.EnvironmentVariablesToSystemPropertiesMappingConfiguration;

@SpringBootApplication
@EnableZuulProxy
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, RestClientAutoConfiguration.class, CassandraAutoConfiguration.class})
public class ConductorBootWrapperOauth2EmbeddedMariadb4jApplication {
	
	private static String[] args_buffer;
	
	@Autowired
	EnvironmentVariablesToSystemPropertiesMappingConfiguration environmentVariablesToSystemPropertiesMappingConfiguration;
	
	//@Value("${server.port:8080}")
	//private int serverPort;

	public static void main(String[] args) throws InterruptedException
    {
        SpringApplication app = new SpringApplication(ConductorBootWrapperOauth2EmbeddedMariadb4jApplication.class);
        args_buffer = args;
        app.run(args);
	}
	
	@EventListener(ApplicationStartedEvent.class)
	public void mapEnvToProp()
	{
		/*
		 * int conductorPort = PortAvailabilityUtils.randomFreePort();
		 * 
		 * RestTemplate restTemplate = new RestTemplate();
		 * 
		 * ResponseEntity<String> updateResponse =
		 * restTemplate.postForEntity("http://localhost:"+serverPort+"/env",
		 * "{\"conductor.jetty.server.port\":\""+conductorPort+"\"}", String.class);
		 * 
		 * System.out.println(updateResponse.getStatusCodeValue());
		 * 
		 * ResponseEntity<String> refreshResponse =
		 * restTemplate.postForEntity("http://localhost:"+serverPort+"/refresh", null,
		 * String.class);
		 * 
		 * System.out.println(refreshResponse.getStatusCodeValue());
		 */
		
		this.environmentVariablesToSystemPropertiesMappingConfiguration.mapEnvToProp();
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void startConductorServer() throws InterruptedException {
		
		ConductorRunnerThreadProvider conductorRunnerThread = ConductorRunnerThreadProvider.getInstance();
		
		conductorRunnerThread.configureArgs(args_buffer);
		conductorRunnerThread.start();  
	}

}
