package bootstrap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import bootstrap.service.CommentsService;
import bootstrap.service.InMemCommentsService;
import bootstrap.web.CommentsController;
import bootstrap.web.IndexController;

@EnableWebMvc
@Configuration
public class JspApplicationConfiguration {

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
		return jspViewResolver;
	}
}
