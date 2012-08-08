package bootstrap.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bootstrap.data.Comment;
import bootstrap.service.CommentsService;

@Controller
@RequestMapping("/comments")
public class CommentsController {

	@Autowired
	public CommentsService commentsService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getComments() {
		ModelAndView modelAndView = new ModelAndView("comments");
		List<Comment> comments = commentsService.getComments();
		modelAndView.addObject("comments", comments);
		modelAndView.addObject("commentForm", new Comment());
		return modelAndView;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getComment(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("comment");
		for (Comment comment : commentsService.getComments()) {
			if (id.equals(comment.getId())) {
				modelAndView.addObject("comment", comment);
			}
		}
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String postCommentForm(@ModelAttribute Comment comment) {
		commentsService.addComment(comment);
		return "redirect:/comments";
	}
}
