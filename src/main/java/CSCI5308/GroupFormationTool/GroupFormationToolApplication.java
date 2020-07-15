package CSCI5308.GroupFormationTool;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class GroupFormationToolApplication {

	static final Logger logger = LoggerFactory.getLogger(GroupFormationToolApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GroupFormationToolApplication.class, args);
		log.warn("This is a Log Example.");
	}

}
