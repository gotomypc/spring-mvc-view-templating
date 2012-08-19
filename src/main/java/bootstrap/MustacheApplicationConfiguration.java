package bootstrap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.mustache.MustacheTemplateLoader;
import org.springframework.web.servlet.view.mustache.MustacheViewResolver;

import bootstrap.service.CommentsService;
import bootstrap.service.InMemCommentsService;
import bootstrap.web.CommentsController;
import bootstrap.web.IndexController;

@EnableWebMvc
@Configuration
public class MustacheApplicationConfiguration {

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
	public ViewResolver viewResolver(ResourceLoader resourceLoader) {
		MustacheViewResolver mustacheViewResolver = new MustacheViewResolver();
		mustacheViewResolver.setPrefix("/WEB-INF/views/");
		mustacheViewResolver.setSuffix(".mustache");
		MustacheTemplateLoader mustacheTemplateLoader = new MustacheTemplateLoader();
		mustacheTemplateLoader.setResourceLoader(resourceLoader);
		mustacheViewResolver.setTemplateLoader(mustacheTemplateLoader);
		return mustacheViewResolver;
	}
}
