package fi.haagahelia.exercises.Bookstore.web;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.exercises.Bookstore.Domain.Book;
import fi.haagahelia.exercises.Bookstore.Domain.BookRepository;
import fi.haagahelia.exercises.Bookstore.Domain.CategoryRepository;


@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository catrepository;
	
	@GetMapping(value="/login")
	public String loginPage(Model model) {
		return "login";
	}
	
	@GetMapping(value="/")
	@ResponseBody
	public String test() {
		return "Hello World";
	}
	
	@GetMapping(value="/booklist")
	public String BookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", catrepository.findAll());
		return "addbook";
	}
	
	@PostMapping(value="/save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	// Delete student
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") Long BookId, Model model) {
    	repository.deleteById(BookId);
        return "redirect:../booklist";
    }
	
	@RequestMapping(value="/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", catrepository.findAll());
		return "editbook";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.POST)
	public String logoutPage() {
		return "login";
	}
}
