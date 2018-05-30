package com.mastertutorial.mvc.configuration;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * This class will automatically configure FrontController/
 * DispatcherServlet and the spring application context in the application servlet context.
 * The container looks for any classes in the classpath that implement the javax.servlet
.ServletContainerInitializer interface; if any are found, they’re used to configure
the servlet container.
 * @author Yashwanth
 *
 */
public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ProjectConfigurator.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method defines which servlet mapping to map the dispatcher servlet.
	 */
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

	 @Override
	    protected Filter[] getServletFilters() {
	    	Filter [] singleton = { new CORSFilter()};
	    	return singleton;
	    }
}
