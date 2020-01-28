package fr.alteca.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "fr.alteca.dashboard")
public class App {
  public static void main(String[] args) {
	// java -jar bitbucket-dashboard-spring-ui-1.0-SNAPSHOT.jar -Djavax.net.ssl.trustStore=gitcacerts.jks
	SpringApplication.run(App.class, args);
  }
}