package com.test2.test2;

import com.test2.test2.operations.Operations2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories
public class Test2Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext container=SpringApplication.run(Test2Application.class, args);
		Operations2 operations2=container.getBean(Operations2.class);

//		operations2.add();
//		operations2.m();
//		operations2.update();
//		operations2.sorting();
//		operations2.pagination();
//		operations2.select();
//		operations2.insertingNameQuery();
//		operations2.deletingNamedQuery();
//		operations2.updatingNamedQuery();
//		operations2.Named();
		operations2.selectJPQL();
//		int exitCode = SpringApplication.exit(container, () -> 0);
//		System.exit(exitCode);
	}

}
