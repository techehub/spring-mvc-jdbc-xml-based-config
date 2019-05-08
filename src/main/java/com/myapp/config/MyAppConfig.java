package com.myapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.myapp.dao.UserDao;
import com.myapp.dao.UserDaoImpl;
import com.myapp.service.UserService;
import com.myapp.service.UserServiceImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.myapp")
@PropertySource(value = { "classpath:application.properties" })

public class MyAppConfig  extends WebMvcConfigurerAdapter{


	@Autowired
	private Environment env;


	@Bean
	    public ViewResolver viewResolver() {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        //viewResolver.setViewClass(JstlView.class);
	        viewResolver.setPrefix("/WEB-INF/pages/");
	        viewResolver.setSuffix(".jsp");
	        return viewResolver;
	    }
	 
	    @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }
	    
	    /**
	    @Bean
	    public UserService userService() {
	    	return new UserServiceImpl();
	    }
	    	
	    @Bean
	    public UserDao userDAO() {
	    	return new UserDaoImpl();
	    }
	    
	    */
	    
	    @Bean 
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
	        dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
	        dataSource.setUsername(env.getRequiredProperty("jdbc.user"));
	        dataSource.setPassword(env.getRequiredProperty("jdbc.pwd"));
	        return dataSource;
	    }
	 
	    @Bean
	    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
	        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	        //jdbcTemplate.setDataSource(dataSource);
	        return jdbcTemplate;
	    }
	    

}
