package konami.pes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import konami.pes.controllers.HomeController;

@Configuration
@EnableWebMvc
@ComponentScan("konami.pes")
@Import(HibernateConfiguration.class)
@EnableAspectJAutoProxy
public class WebMvcConfig extends WebMvcConfigurerAdapter {

//	@Bean
//	public ViewResolver viewResolver() {
//	InternalResourceViewResolver resolver =
//	new InternalResourceViewResolver();
//	resolver.setPrefix("/WEB-INF/views/");
//	resolver.setSuffix(".jsp");
//	resolver.setExposeContextBeansAsAttributes(true);
//	return resolver;
//	}
	@Bean
	public HomeController homeController(){
		return new HomeController();
	}
	 @Override
		public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		}
	 @Bean
	 public CommonsMultipartResolver multipartResolver() {
	     CommonsMultipartResolver resolver=new CommonsMultipartResolver();
	     resolver.setDefaultEncoding("utf-8");
	     return resolver;
	 }
	 @Bean
	 public TilesConfigurer tilesConfigurer() {
	 TilesConfigurer tiles = new TilesConfigurer();
	 tiles.setDefinitions(new String[] {
	 "/WEB-INF/layout/tiles.xml"
	 });
	 tiles.setCheckRefresh(true);
	 return tiles;
	 }
	 @Override
	    public void configureViewResolvers(ViewResolverRegistry registry) {
	        TilesViewResolver viewResolver = new TilesViewResolver();
	        registry.viewResolver(viewResolver);
	    }
}
