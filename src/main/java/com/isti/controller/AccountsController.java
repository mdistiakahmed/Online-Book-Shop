package com.isti.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.isti.model.Accounts;
import com.isti.model.Book;
import com.isti.model.Orders;
import com.isti.model.Shop;
import com.isti.service.AccountsService;
import com.isti.service.BookService;
import com.isti.service.OrderService;
import com.isti.service.ShopService;


@Controller
public class AccountsController {
	@Autowired
	private BookService bookService;
	@Autowired
	private AccountsService accountService;
	@Autowired
	private ShopService shopService;
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("loginForm");
		
		return model;

	}
	
	@RequestMapping("/signup")
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView("signupForm");
		
		return model;

	}
	
	public ModelAndView home(){
		ModelAndView model = new ModelAndView("home");
		Book book = new Book();
		model.addObject("book", book);
		model.addObject("bookList", bookService.getAllBook());
		return model;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		session.removeAttribute("role");
		session.removeAttribute("shopid");
		 return "redirect:/home";
	}
	
	@RequestMapping(value = "/loginForm", method = RequestMethod.POST)
	public String doAct(@ModelAttribute("acc")Accounts acc,BindingResult result,HttpSession session){
		Accounts ob=accountService.getAccount(acc.getUserName());
		if(ob==null || ob.getPassword().equals(acc.getPassword())==false){
			 return "redirect:/login";
		}
		else{
			session.setAttribute("user", ob.getUserName());
			session.setAttribute("role", ob.getRole());
			if(ob.getRole().equalsIgnoreCase("shop")){
				Shop sp=shopService.getAccount(ob.getUserName());
				session.setAttribute("shopid",sp.getShopid());
			}
		}
		 return "redirect:/home";
		
	}
	
	@RequestMapping(value = "/signupForm", method = RequestMethod.POST)
	public String signUpAction(@ModelAttribute("acc")Accounts acc,BindingResult result,HttpSession session){
		if(!acc.getRole().equalsIgnoreCase("user") &&
			!acc.getRole().equalsIgnoreCase("shop")) return "redirect:/signup";;
		Accounts ob=accountService.getAccount(acc.getUserName());
		if(ob==null){
			if(acc.getRole().equalsIgnoreCase("shop")){
				Shop sp=new Shop();
				sp.setManagername(acc.getUserName());
				shopService.add(sp);	
			}
			accountService.add(acc);
			 return "redirect:/login";
		}
		else{
			 return "redirect:/signup";
		}
		
	}
	
	@RequestMapping("/showAllShop")
	public ModelAndView showAllShop() {
		ModelAndView model = new ModelAndView("showAllShop");
		Shop sp = new Shop();
		model.addObject("shop", sp);
		model.addObject("shopList", shopService.getAllShop());
		return model;

	}
	
	@RequestMapping("/removeShop")
    public String DeleteOrder(HttpServletRequest request,
            @RequestParam(value = "name") String name) {
    	Shop sp=null;
    	Accounts ac=null;
    	sp=shopService.getAccount(name);
    	ac=accountService.getAccount(name);
    	List<Orders>oll =orderService.getAllOrder();
    	for(Orders od:oll){
        	if(od.getShopid()==sp.getShopid()){
        		orderService.delete(od);
        	}
        }
    	 
    	List<Book>ll=bookService.getAllBook();
        for(Book book:ll){
        	if(book.getStoreId()==sp.getShopid()){
        		bookService.delete(book);
        	}
        }
    	shopService.delete(sp);
        accountService.delete(ac);
          
        return "redirect:/showAllShop";
    }
	
	
	@RequestMapping("/showAllUser")
	public ModelAndView showAllUser() {
		ModelAndView model = new ModelAndView("showAllUsers");
		Accounts ac = new Accounts();
		model.addObject("account", ac);
		model.addObject("accountList", accountService.getAllAccount());
		return model;

	}
	
	@RequestMapping("/removeUser")
    public String DeleteUser(HttpServletRequest request,
            @RequestParam(value = "name") String name) {
    	Accounts ac=null;
        ac=accountService.getAccount(name);
        accountService.delete(ac);
        List<Orders>ll=orderService.getAllOrder();
        for(Orders od:ll){
        	if(od.getUsername().equalsIgnoreCase(name)){
        		orderService.delete(od);
        	}
        }
        return "redirect:/showAllUser";
    }
	

}
