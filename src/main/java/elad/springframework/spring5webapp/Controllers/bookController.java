package elad.springframework.spring5webapp.Controllers;

import elad.springframework.spring5webapp.repositories.BookRep;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller/*make this class to spring MVC controller*/
public class bookController {
    private final BookRep bookRep;

    public bookController(BookRep bookRep) {
        this.bookRep = bookRep;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("book",bookRep.findAll());
        return "books/list";
    }
}
