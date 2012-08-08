package bootstrap;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import bootstrap.service.CommentsService;
import bootstrap.service.InMemCommentsService;
import bootstrap.web.CommentsController;
import bootstrap.web.IndexController;

@EnableWebMvc
@Configuration
public class ApplicationConfiguration {

	@Bean
	public CommentsService commentsService() {
		return new InMemCommentsService();
	}

	@Bean
	public IndexController indexController() {
		return new IndexController();
	}

	@Bean
	public CommentsController commentsController() {
		return new CommentsController();
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();
		jspViewResolver.setPrefix("/WEB-INF/views/");
		jspViewResolver.setSuffix(".jsp");

		ContentNegotiatingViewResolver contentNegotiatingViewResolver = new ContentNegotiatingViewResolver();
		List<ViewResolver> viewResolvers = new LinkedList<ViewResolver>();
		viewResolvers.add(jspViewResolver);
		contentNegotiatingViewResolver.setViewResolvers(viewResolvers);

		MappingJacksonJsonView mappingJacksonJsonView = new MappingJacksonJsonView();
		List<View> defaultViews = new LinkedList<View>();
		defaultViews.add(mappingJacksonJsonView);
		contentNegotiatingViewResolver.setDefaultViews(defaultViews);

		return contentNegotiatingViewResolver;
	}
}

