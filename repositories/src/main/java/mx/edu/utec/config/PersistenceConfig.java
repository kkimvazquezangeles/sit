package mx.edu.utec.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
@EnableJpaRepositories(basePackages = {"mx.edu.utec.repositories"})
public class PersistenceConfig {

    @Bean
    public DataSource dataSource() {
        /*EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        builder.addScript("classpath:/mx/edu/utec/scripts/alumno.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/carrera.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/cuatrimestre.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/grupo.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/periodo.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/personal.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/periodoAlumno.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/periodoPersonal.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/tutoria.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/materia.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/cuatrimestreMateria.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/tutor.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/plan.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/planDetalle.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/director.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/user.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/constraints.sql");
        return builder.setType(EmbeddedDatabaseType.H2).build(); */

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/sitdb?useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("password");

        return dataSource;
    }

    @Bean
    public DataSourceInitializer dataSourceInitializer() {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        /*
        resourceDatabasePopulator.addScript(new ClassPathResource("/mx/edu/utec/scripts/carrera-data.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("/mx/edu/utec/scripts/cuatrimestre-data.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("/mx/edu/utec/scripts/grupo-data.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("/mx/edu/utec/scripts/materia-data.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("/mx/edu/utec/scripts/periodo-data.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("/mx/edu/utec/scripts/personal-data.sql"));


        resourceDatabasePopulator.addScript(new ClassPathResource("/mx/edu/utec/scripts/periodoPersonal-data.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("/mx/edu/utec/scripts/tutor-data.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("/mx/edu/utec/scripts/alumno-data.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("/mx/edu/utec/scripts/periodoAlumno-data.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("/mx/edu/utec/scripts/tutoria-data.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("/mx/edu/utec/scripts/plan-data.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("/mx/edu/utec/scripts/planDetalle-data.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("/mx/edu/utec/scripts/planTutoria-data.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("/mx/edu/utec/scripts/cuatrimestreMateria-data.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("/mx/edu/utec/scripts/director-data.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("/mx/edu/utec/scripts/user-data.sql"));*/

        /*resourceDatabasePopulator.addScript(new ClassPathResource("/mx/edu/utec/scripts/utec/real-data.sql"));*/

        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource());
        dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
        return dataSourceInitializer;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
                                                                       JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(dataSource);
        lef.setJpaVendorAdapter(jpaVendorAdapter);
        lef.setPackagesToScan("mx.edu.utec.model");
        return lef;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }
}
