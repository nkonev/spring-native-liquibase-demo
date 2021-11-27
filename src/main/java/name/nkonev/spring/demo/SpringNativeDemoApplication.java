package name.nkonev.spring.demo;

import liquibase.change.core.SQLFileChange;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.nativex.hint.*;

@NativeHint(
        trigger = SpringLiquibase.class,
        types = {
                // Native reflection configuration for <init>() is missing.
                // https://github.com/spring-projects-experimental/spring-native/commit/10001243782238ba93ef62f982350c3f3252c31d
                @TypeHint(types = {
                        liquibase.configuration.LiquibaseConfiguration.class,
                        liquibase.logging.core.LogServiceFactory.class,
                        liquibase.license.LicenseServiceFactory.class,
                        liquibase.executor.ExecutorService.class,
                        liquibase.change.ChangeFactory.class,
                        liquibase.sql.visitor.PrependSqlVisitor.class,
                        liquibase.sql.visitor.AppendSqlVisitor.class,
                        liquibase.sql.visitor.RegExpReplaceSqlVisitor.class,
                        liquibase.sql.visitor.ReplaceSqlVisitor.class,
                        liquibase.hub.HubServiceFactory.class,
                },
                        access = AccessBits.LOAD_AND_CONSTRUCT),
                // Getters and setters
                @TypeHint(types = {
                        SQLFileChange.class
                },
                        access = AccessBits.LOAD_AND_CONSTRUCT_AND_PUBLIC_METHODS
                ),
        }
)
@SpringBootApplication
public class SpringNativeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringNativeDemoApplication.class, args);
    }

}
