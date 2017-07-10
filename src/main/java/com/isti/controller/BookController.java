package com.isti.controller;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.isti.dao.Utils;
import com.isti.model.Accounts;
import com.isti.model.Book;
import com.isti.model.CartInfo;
import com.isti.model.CartLineInfo;
import com.isti.model.Orders;
import com.isti.model.Shop;
import com.isti.service.AccountsService;
import com.isti.service.BookService;
import com.isti.service.OrderService;
import com.isti.service.ShopService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	@Autowired
	private AccountsService accountService;
	@Autowired
	private ShopService shopService;
	@Autowired
	private OrderService orderService;

	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("home");
		Book book = new Book();
		model.addObject("book", book);
		model.addObject("bookList", bookService.getAllBook());
		return model;

	}
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView doActions(@ModelAttribute Book book,
			BindingResult result, @RequestParam String action,
			@RequestParam CommonsMultipartFile fileUpload,HttpSession session) throws Exception {

		ModelAndView model = new ModelAndView("home");
		Book bookResult = new Book();

		System.out.println("Saving file: " + fileUpload.getOriginalFilename());

		book.setImage(fileUpload.getBytes());
		switch (action.toLowerCase()) { // only in Java7 you can put String in
										// switch
		case "add":
			book.setStoreId((int)session.getAttribute("shopid"));
			bookService.add(book);
			bookResult = book;
			break;
		case "edit":

			break;
		case "delete":

			break;
		case "search":

			break;
		}
		model.addObject("book", bookResult);
		model.addObject("bookList", bookService.getAllBook());
		return model;
	}
	
	@RequestMapping(value = "/image")
	  public void showImage(@RequestParam("id") Integer itemId, HttpServletResponse response,HttpServletRequest request) 
	          throws ServletException, IOException{

	    Book item = bookService.getBook(itemId);       
	    response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	    response.getOutputStream().write(item.getImage());


	    response.getOutputStream().close();
	}
	
	@RequestMapping("/showProduct")
	public ModelAndView showParticulerBook(@RequestParam("code") Integer code){
		ModelAndView model = new ModelAndView("AParticularBook");
		Book book =bookService.getBook(code);
		model.addObject("book", book);
		return model;
	}
	
	 @RequestMapping({ "/buyProduct" })
	    public String listProductHandler(HttpServletRequest request,
	            @RequestParam(value = "code") int code) {
		    String user = (String) request.getSession().getAttribute("user");
		    if(user==null){
		    	return "redirect:/login";
		    }
	 
	        Book product = null;
	        product = bookService.getBook(code);

	        // Cart info stored in Session.
            CartInfo cartInfo = Utils.getCartInSession(request);
 
            cartInfo.addProduct(product, 1);
            
	        return "redirect:/shoppingCart";
	    }
	 
	 @RequestMapping({ "/removeFromCart" })
	    public String removefromCart(HttpServletRequest request,
	            @RequestParam(value = "code") int code) {
	 
	        Book product = null;
	        product = bookService.getBook(code);

	        // Cart info stored in Session.
         CartInfo cartInfo = Utils.getCartInSession(request);

         cartInfo.removeProduct(product);
         
	        return "redirect:/shoppingCart";
	    }
	 
	 @RequestMapping({ "/submitCart" })
	    public String SubmitCart(HttpServletRequest request,HttpSession req) {
	        // Cart info stored in Session.
         CartInfo cartInfo = Utils.getCartInSession(request);
         List<CartLineInfo>l=cartInfo.getCartLines();
         for(CartLineInfo cli:l){
        	 Orders od=new Orders();
        	 od.setBookid(cli.getProductInfo().getBookId());
        	 od.setShopid(cli.getProductInfo().getStoreId());
        	 System.out.println((String)req.getAttribute("user"));
        	 od.setUsername((String)req.getAttribute("user"));
        	 //od.setShopid(2);
        	 
        	 orderService.add(od);
         }
         Utils.removeCartInSession(request);
         
         
	        return "redirect:/shoppingCart";
	    }
	 
	 
	 
	// GET: Show Cart
	    @RequestMapping(value = { "/shoppingCart" }, method = RequestMethod.GET)
	    public ModelAndView shoppingCartHandler(HttpServletRequest request) {
	        CartInfo myCart = Utils.getCartInSession(request);
	        
	        ModelAndView model = new ModelAndView("shoppingCart");
			Book book = new Book();
			model.addObject("book", book);
			model.addObject("bookList", bookService.getAllBook());
			return model;
	
	    }
	    
	    @RequestMapping("/addBook")
		public ModelAndView addbook() {
			ModelAndView model = new ModelAndView("addBook");
			Book book = new Book();
			model.addObject("book", book);
			return model;

		}
	    
	    
	    @RequestMapping("/delete")
	    public String DeleteBook(HttpServletRequest request,
	            @RequestParam(value = "code") int code) {
	    	Book product = null;
	        product = bookService.getBook(code);
	        bookService.delete(product);
	        return "redirect:/home";
	    }

	    
	   
	    
	    @RequestMapping("/showOrders")
		public ModelAndView viewOrders() {
			ModelAndView model = new ModelAndView("showOrders");
			Orders od=new Orders();
			model.addObject("order",od);
			model.addObject("orderList", orderService.getAllOrder());
			return model;

		}
	    
	    @RequestMapping("/removeOrder")
	    public String DeleteOrder(HttpServletRequest request,
	            @RequestParam(value = "code") int code) {
	    	Orders od = null;
	    	od=orderService.getOrder(code);
	        orderService.delete(od);
	        return "redirect:/showOrders";
	    }
	    
	    @RequestMapping(value = "/search", method = RequestMethod.POST)
		public ModelAndView doSearch(@RequestParam String bname) throws Exception {
	    	System.out.println(")xffffff---");
	    	System.out.println(bname);
	    	List<Book>bll=bookService.getAllBook();
	    	List<Book>ans=new Vector<Book>();
	    	for(Book bk:bll){
	    		if(bk.getName().equalsIgnoreCase(bname)
	    			|| bk.getAuthor().equalsIgnoreCase(bname)
	    			|| bk.getPublisher().equalsIgnoreCase(bname)
	    			||bk.getGenra().equalsIgnoreCase(bname)){
	    			ans.add(bk);
	    		}
	    	}
	    	
	    	ModelAndView model = new ModelAndView("home");
			Book bok = new Book();
			model.addObject("book", bok);
			model.addObject("bookList", ans);
			return model;
		}
	    
	    

}
