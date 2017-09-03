package konami.pes.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class PesWebAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext context) throws ServletException {
		
		AnnotationConfigWebApplicationContext rootContext=new AnnotationConfigWebApplicationContext();
		rootContext.register(WebMvcConfig.class);
		rootContext.setServletContext(context);
		
		Dynamic dispatcher=context.addServlet("dispatcher", new DispatcherServlet(rootContext));
		dispatcher.addMapping("/");
		dispatcher.setLoadOnStartup(1);
		
	}

//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		
//		//registrovanje servleta dodatnih
////		Dynamic myServlet =
////				servletContext.addServlet("myServlet", MyServlet.class);
////				myServlet.addMapping("/custom/**");
//		
//		//registrovanje filtera
////		javax.servlet.FilterRegistration.Dynamic filter =
////				servletContext.addFilter("myFilter", MyFilter.class);
////				filter.addMappingForUrlPatterns(null, false, "/custom/*");
//				
//	}
//	@Override
//	protected Class<?>[] getRootConfigClasses() {
//		
//		return new Class<?>[]{RootConfig.class};
//	}
//
//	@Override
//	protected Class<?>[] getServletConfigClasses() {
//		
//		return new Class<?>[]{WebMvcConfig.class};
//	}
//
//	@Override
//	protected String[] getServletMappings() {
//		
//		return new String[]{"/"};
//	}
	
	//ova metoda se poziva kada se registruje dispetcher, moze se overrideovati i dodati nove konfiguracije
	
//	With the ServletRegistration.Dynamic that’s given to customizeRegistration(),
//	you can do several things, including set the load-on-startup priority by calling set-
//	LoadOnStartup(), set an initialization parameter by calling setInitParameter(), and
//	call setMultipartConfig() to configure Servlet 3.0 multipart support. In the preceding
//	example, you’re setting up multipart support to temporarily store uploaded files
//	at /tmp/spittr/uploads.
//	@Override
//	protected void customizeRegistration(Dynamic registration) {     
//		// TODO Auto-generated method stub
//		super.customizeRegistration(registration);
//		//registration.setMultipartConfig(new MultipartConfigElement("/tmp/spittr/uploads"));
//	}
//	@Override
//	protected Filter[] getServletFilters() {
//		// TODO Auto-generated method stub
//		return super.getServletFilters();
//	}
	
	//web.xml example
//	<?xml version="1.0" encoding="UTF-8"?>
//	<web-app version="2.5"
//	xmlns="http://java.sun.com/xml/ns/javaee"
//	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
//	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
//	http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">
//	<context-param>
//	<param-name>contextConfigLocation</param-name>
//	<param-value>/WEB-INF/spring/root-context.xml</param-value>
//	</context-param>
//	<listener>
//	<listener-class>
//	org.springframework.web.context.ContextLoaderListener
//	</listener-class>
//	</listener>
//	<servlet>
//	<servlet-name>appServlet</servlet-name>
//	<servlet-class>
//	org.springframework.web.servlet.DispatcherServlet
//	</servlet-class>
//	<load-on-startup>1</load-on-startup>
//	</servlet>
//	<servlet-mapping>
//	<servlet-name>appServlet</servlet-name>
//	<url-pattern>/</url-pattern>
//	</servlet-mapping>
//	</web-app>
	
	
//	DispatcherServlet loads its application context with beans defined in a file whose
//	name is based on the servlet name. In listing 7.3, the servlet is named appServlet.
//	Therefore, DispatcherServlet loads its application context from an XML file at /
//	WEB-INF/appServlet-context.xml.
//	If you’d rather specify the location of the DispatcherServlet configuration file,
//	you can set a contextConfigLocation initialization parameter on the servlet. For
//	example, the following DispatcherServlet configuration has DispatcherServlet
//	loading its beans from /WEB-INF/spring/appServlet/servlet-context.xml:
	
//	<servlet>
//	<servlet-name>appServlet</servlet-name>
//	<servlet-class>
//	org.springframework.web.servlet.DispatcherServlet
//	</servlet-class>
//	<init-param>
//	<param-name>contextConfigLocation</param-name>
//	<param-value>
//	/WEB-INF/spring/appServlet/servlet-context.xml
//	</param-value>
//	</init-param>
//	<load-on-startup>1</load-on-startup>
//	</servlet>
}
