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

import com.my.conductorbootwrapperoauth2embeddedmariadb4j.environment.config.EnvironmentVariablesToSystemPropertiesMappingConfiguration;
import com.netflix.conductor.bootstrap.Main;

@SpringBootApplication
@EnableZuulProxy
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, RestClientAutoConfiguration.class, CassandraAutoConfiguration.class})
public class ConductorBootWrapperOauth2EmbeddedMariadb4jApplication {
	
	private static String[] args_buffer;
	
	@Autowired
	EnvironmentVariablesToSystemPropertiesMappingConfiguration environmentVariablesToSystemPropertiesMappingConfiguration;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ConductorBootWrapperOauth2EmbeddedMariadb4jApplication.class);
        args_buffer = args;
        app.run(args);
	}
	@EventListener(ApplicationStartedEvent.class)
	public void mapEnvToProp()
	{
		this.environmentVariablesToSystemPropertiesMappingConfiguration.mapEnvToProp();
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void startConductorServer() {
		
		try {
			
			if(null!=args_buffer && args_buffer.length > 0)
		      {	
		        String[] args_new = new String[args_buffer.length-1];
		        
		        for(String arg: args_buffer)
		        {
		          if(!"--spring.output.ansi.enabled=always".equalsIgnoreCase(arg))
		          {
		            args_new[args_new.length] = arg;
		          }
		        }
		        
		        Main.main(args_new);
		      }
		      else
		      {	        
		        Main.main(args_buffer);
		    }

		}
		catch(Exception e)
		{
			System.out.println("############################# MYSQL SHUTDOWN #############################");
		}
		
	}

}
