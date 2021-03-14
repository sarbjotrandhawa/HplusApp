package com.test.hplus;

import java.util.Locale;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.format.FormatterRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.test.hplus.converters.StringToEnumConvertor;
import com.test.hplus.interceptors.LoggingInterceptor;



@Configuration
@ComponentScan(basePackages = "com.test.hplus")
public class ApplicationConfig extends WebMvcConfigurationSupport {
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("css/**", "images/**").addResourceLocations("classpath:/static/css/",
				"classpath:/static/images/");
	}

	@Bean
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}

	@Override
	protected void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringToEnumConvertor());
	}

	// Configure ASync thread
	@Override
	protected void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		configurer.setDefaultTimeout(5000);
		configurer.setTaskExecutor(mvcTaskExecutor());
	}

	@Bean
	public AsyncTaskExecutor mvcTaskExecutor() {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setThreadNamePrefix("Hplusapp-thread-");
		return threadPoolTaskExecutor;
	}

	// Register Intercepter
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggingInterceptor()).addPathPatterns("/*");
		registry.addInterceptor(new ThemeChangeInterceptor());//default query param theme:
		registry.addInterceptor(new LocaleChangeInterceptor());//default query: locale
	}
	
	
	 @Bean
	    public ThemeResolver themeResolver() {
	        CookieThemeResolver cookieThemeResolver = new CookieThemeResolver();
	        cookieThemeResolver.setCookieName("theme");
	        cookieThemeResolver.setDefaultThemeName("client-theme1");
	        return cookieThemeResolver;
	    }
	 
	 @Bean
	    public org.springframework.web.servlet.LocaleResolver localeResolver(){
	        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
	        cookieLocaleResolver.setDefaultLocale(Locale.US);
	        cookieLocaleResolver.setCookieName("locale");
	        return cookieLocaleResolver;
	    }
}
