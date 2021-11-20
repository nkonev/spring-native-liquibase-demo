package name.nkonev.spring.demo;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.ResourceHint;

@NativeHint(trigger = Flyway.class, resources = {@ResourceHint(patterns={
        "migration/.*",
////        "/migration/.*",
//        "resources/migration/.*",
//        ".*sql$",
        "org/flywaydb/core/internal/version.txt"
})})
@SpringBootApplication
public class SpringNativeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringNativeDemoApplication.class, args);
	}

}
