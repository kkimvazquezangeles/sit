package mx.edu.utec.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
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
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        builder.addScript("classpath:/mx/edu/utec/scripts/alumno.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/carrera.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/cuatrimestre.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/grupo.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/periodo.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/personal.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/periodoAlumno.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/periodoPersonal.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/tutoria.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/tutoriaDetalle.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/materia.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/cuatrimestreMateria.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/plan.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/planDetalle.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/tutor.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/director.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/user.sql");
        builder.addScript("classpath:/mx/edu/utec/scripts/constraints.sql");
        return builder.setType(EmbeddedDatabaseType.H2).build();

        /*DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/sitdb?useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("password");

        return dataSource;*/
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
        hibernateJpaVendorAdapter.setDatabase(Database.H2);
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }
}
