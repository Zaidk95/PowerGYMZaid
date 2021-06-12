package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;

import org.apache.catalina.realm.UserDatabaseRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.time.Month;

import com.example.demo.models.Time;
import com.example.demo.models.massage;
import com.example.demo.models.rate;
import com.example.demo.models.user;
import com.example.demo.service.msgsrevice;
import com.example.demo.service.rateservice;
import com.example.demo.service.timeservice;
import com.example.demo.service.userService;


@RestController
public class controller {
	@Autowired
	userService usr;
	@Autowired
	timeservice timex;
	@Autowired
	rateservice ratex;
	@Autowired
	msgsrevice income;
	
	// This Controler for user
		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 user  */
	@PostMapping(
			  value = "/add", consumes = "application/json", produces = "application/json")
	public user addUser(@RequestBody user come_user)
	{
		user n = new  user();
		System.out.println(come_user);	
		n.setUsername(come_user.getUsername());
		n.setAge(come_user.getAge());
		n.setEmail(come_user.getEmail());
		n.setPassword(come_user.getPassword());
		n.setGender(come_user.getGender());
	    LocalDate currentdate = LocalDate.now();
		n.setDate(currentdate+"");
		n.setSpecial_id(fill());
		this.usr.adduser(n);
	    return n;
	}
	
	private int RandId() {
		String h = "123456789123456789123456789";
		String a = "";
		for(int i=0; i < 4; i++) {
			int x = (int) (Math.random()*h.length()+0);
			a = a + h.charAt(x)+"";
		}
		return Integer.parseInt(a);
	}

	@RequestMapping("/admin/ch/rate")
	@ResponseBody
	public String find343() {
		String res = "";
		ArrayList<rate> x = (ArrayList<rate>) getAllR();
		double sum=0;
		for(int i = 0 ; i < x.size(); i++) {
			res += x.get(i).getUsername()+"newtr";
			res += x.get(i).getRating()+"newtr";
			sum += x.get(i).getRating();
			res += x.get(i).getTitle()+"newtr";
			res += x.get(i).getDescripe()+"newtr";
			res += x.get(i).getDate()+"newtr";
			res += "newrr";
		}
		double f = sum/x.size();
		return res.substring(0,res.length()-5)+"TTh54sum"+f+"TTh54sum"+x.size();
	}	
	@RequestMapping("/rate/my/{nm}")
	@ResponseBody
	public String find34321(@RequestParam(name="nm") String nm) {
		String res = "";
		double sum=0;
		ArrayList<rate> x = ratex.getMy(nm);
		for(int i = 0 ; i < x.size(); i++) {
			res += x.get(i).getUsername()+"newtr";
			res += x.get(i).getRating()+"newtr";
			sum += x.get(i).getRating();
			res += x.get(i).getTitle()+"newtr";
			res += x.get(i).getDescripe()+"newtr";
			res += x.get(i).getDate()+"newtr";
			res += x.get(i).getID()+"newtr";
			res += "newrr";
		}
		double f = sum/x.size();

		return res.substring(0,res.length()-5)+"TTh54sum"+f+"TTh54sum"+x.size();
	}	
	public int fill() {
		int x = RandId();
		if(exist(x) == true) {
			while(exist(x) == true) {
				x = RandId();
			}
		}
		
		return x;
	}
	public boolean exist(int id) {
		return usr.foundspecial(id);
	}
	
	@GetMapping("/admin/getAll")
	public Collection<user> getAllUsers()
	{
		return usr.getAllUsers(); 
	}
	
	@GetMapping("/getAll")
	public String get()
	{
		return usr.getAllUsers()+""; 
	}
	
	@DeleteMapping("admin/deleteUser/{id}")
	public void removeById(@RequestParam(name="id") int id)
	{
		usr.removeUser(id);
	}
	@DeleteMapping("rate/del/{id}")
	public void removeByIdrate(@RequestParam(name="id") int id)
	{
		ratex.removeReview(id);
	}
	
	@DeleteMapping("admin/deleteall")
	public void Dall()
	{
		usr.removAll();
	}
	
	@RequestMapping("/admin/ch/{email}")
	@ResponseBody
	public boolean isValid(@RequestParam(name="email") String email) 
    { 
		String [] p = email.split("@");
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 

	@RequestMapping("/admin/va/{email}")
	@ResponseBody
	public boolean IsFound(@RequestParam(name="email") String x) {
		return usr.foundem(x);
	}
	
	@RequestMapping("/agec/{id}")
	@ResponseBody
	public int myAge(@RequestParam(name="id") int x) {
		user a = usr.findById(x);
		String age = a.getAge();
		String[] part1= age.split("-");
	    LocalDate currentdate = LocalDate.now();
		String[] part2= (currentdate+"").split("-");
		int ag = Integer.parseInt(part2[0]) - Integer.parseInt(part1[0]);
		if(Integer.parseInt(part1[1]) > Integer.parseInt(part2[1])){
			ag--;
		}
		if(Integer.parseInt(part1[1]) == Integer.parseInt(part2[1])) {
			if(Integer.parseInt(part1[2]) > Integer.parseInt(part2[2])) {
				ag--;
			}
		}
		return ag;
	}
	
	@RequestMapping("/admin/na/{name}")
	@ResponseBody
	public boolean IsFoundna(@RequestParam(name="name") String x) {
		return usr.foundname(x);
	}
	
	@RequestMapping("/admin/id/{id}")
	@ResponseBody
	public boolean IsFoundnid(@RequestParam(name="id") int x) {
		return usr.foundSpecial(x);
	}
	
	@RequestMapping("/send/{email}/{password}")
	@ResponseBody
	public boolean IsFound(@PathVariable(name="email") String x, @PathVariable(name="password") String y) {
		return (usr.Login1(x,y) || usr.Login2(x,y));
	}
	
	@RequestMapping("/getidi/{em}")
	@ResponseBody
	public int getbyid(@RequestParam(name="em") String x) {
		return usr.getidbyid(x);
	}
	
	@RequestMapping("/getide/{em}")
	@ResponseBody
	public int getbyem(@RequestParam(name="em") String x) {
		return usr.getidbyem(x);
	}

	@RequestMapping("/admin/info/{id}")
	@ResponseBody
	public String find(@RequestParam(name="id") int a) {
		user n = usr.findById(a);	
		return n.getUsername()+"--"+n.getSpecial_id()+"--"+n.getAge()+"--"+n.getEmail()+"--"+n.getPassword()+"--"+n.getGender()+"--"+n.getDate();
	}	
	@RequestMapping("/admin/gn/{id}")
	@ResponseBody
	public String findname(@RequestParam(name="id") int a) {
		user n = usr.findById(a);	
		return n.getUsername()+" # "+n.getSpecial_id();
	}	
	@PutMapping("/chpass/{id}/{pass}")
	@ResponseBody
	public user getbyb(@PathVariable(name="id") int x, @PathVariable(name="pass") String y) {
		user a = usr.findById(x);
		a.setPassword(y);
		usr.adduser(a);
		return a;
	}
	@PutMapping("/chem/{id}/{age}")
	@ResponseBody
	public user chAge(@PathVariable(name="id") int x, @PathVariable(name="age") String y) {
		user a = usr.findById(x);
		a.setEmail(y);
		usr.adduser(a);
		return a;
	}
	@PutMapping("/chname/{id}/{name}")
	@ResponseBody
	public user chName(@PathVariable(name="id") int x, @PathVariable(name="name") String y) {
		user a = usr.findById(x);
		a.setUsername(y);
		usr.adduser(a);
		return a;
	}
	
	@RequestMapping("/pass/{ps}")
	@ResponseBody
	public int isValidpass(@RequestParam(name="ps") String password) 
    { 
		    boolean big = false;
		    boolean small = false;
		    boolean num = false;
		    boolean smp = false;
		   for(int i=0; i < password.length(); i++) {
			   if(Character.isUpperCase(password.charAt(i))) {
				   big = true;
			   }
			   if(Character.isLowerCase(password.charAt(i))) {
				   small = true;
			   }
			   if(Character.isDigit(password.charAt(i))) {
				   num = true;
			   }
			   if(password.charAt(i) == '$' ||
					   password.charAt(i) == '&' ||
					   password.charAt(i) == '.' ||
					   password.charAt(i) == '@' ||
					   password.charAt(i) == '!' ||
					   password.charAt(i) == '*' ||
					   password.charAt(i) == '%' ||
					   password.charAt(i) == '^' ||
					   password.charAt(i) == '(' ||
					   password.charAt(i) == ')' ||
					   password.charAt(i) == '+' ||
					   password.charAt(i) == '-') {
				   smp = true;
			   }
			   
		   }
		   if(big && small && smp && num && password.length() > 5 && password.length() < 12) 
			   return 4;
		   if(big && small && smp && password.length() > 5 && password.length() < 12 || big && num && smp && password.length() > 5 && password.length() < 12 || 
				   small && smp && num && password.length() > 5 && password.length() < 12 || big && small && num && password.length() > 5 && password.length() < 12) {
			   return 3;
		   }
		   if(big && small && password.length() > 5 && password.length() < 12 || big && num && password.length() > 5 && password.length() < 12 || 
				   big && smp && password.length() > 5 && password.length() < 12 || small && num && password.length() > 5 && password.length() < 12 || small && smp && password.length() > 5 && password.length() < 12 ||
				   smp && num && password.length() > 5 && password.length() < 12 ) {
			   return 2;
		   }
		   if(big || small || smp || num && password.length() > 5 && password.length() < 12) 
			   return 1;
		   return 0; 
    }
	@RequestMapping("/getmf")
	@ResponseBody
	public String num2() 
    { 
		return usr.maleandfemale();
    }
	// This Controler for hour 
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 hour  */
	
	@PostMapping(
			  value = "/time/add", consumes = "application/json", produces = "application/json")
	public Time addUser(@RequestBody Time hr)
	{
		Time n = new  Time();
		System.out.println(hr);	
		n.setName(hr.getName());
		LocalDate currentdate = LocalDate.now();
		n.setDate(currentdate+"");
		n.setStart(hr.getStart());
		n.setFinish(hr.getFinish());
		n.setTotal(calc(hr.getStart(),hr.getFinish()));
		timex.addTime(n);
	    return n;
	}
	public double calc(String a , String b) {
		String [] t1 = a.split(":");
		String [] t2 = b.split(":");
		double h1 = Double.parseDouble(t1[0]); 
		double h2 = Double.parseDouble(t2[0]); 
		double m1 = Double.parseDouble(t1[1]); 
		double m2 = Double.parseDouble(t2[1]); 
		double res = (h2*60+m2) - (h1*60+m1);
		return round(res/60 , 2);
	}
	public double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	@GetMapping("/times")
	public Collection<Time> getAlltime()
	{
		return timex.getAllUsers();
	}
	@RequestMapping("/getime/{nm}")
	@ResponseBody
	public String gettime(@RequestParam(name="nm") String name)
	{
		return timex.getone(name);
	}
	@RequestMapping("/getimes/{nm}")
	@ResponseBody
	public String getimes(@RequestParam(name="nm") String name)
	{
		ArrayList<Time> arr = timex.getTimesForMe(name);
		String res = "";
		double sum = 0;
		for(int i=0; i<arr.size(); i++) {
			if(i == arr.size()-1) {
				res += arr.get(i).getDate()+"newtr";
				res += arr.get(i).getStart()+"newtr";
				res += arr.get(i).getFinish()+"newtr";
				res += arr.get(i).getTotal()+"newtr";
				sum += arr.get(i).getTotal();
			}
			else {
			res += arr.get(i).getDate()+"newtr";
			res += arr.get(i).getStart()+"newtr";
			res += arr.get(i).getFinish()+"newtr";
			res += arr.get(i).getTotal()+"newtr";
			sum += arr.get(i).getTotal();
			res += "newrr";
			}
		}
		return res+"wowww"+sum;
	}
	// This Controler for rating 
		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		rating  */
	
	@PostMapping(
			  value = "/rate/add", consumes = "application/json", produces = "application/json")
	public rate addRate(@RequestBody rate rv)
	{
		rate n = new rate();
		System.out.println(rv);	
		n.setUsername(rv.getUsername());
		n.setDescripe(rv.getDescripe());
		n.setTitle(rv.getTitle());
		n.setRating(rv.getRating());
		LocalDate currentdate = LocalDate.now();
		n.setDate(currentdate+"");
		ratex.addReview(n);
	    return n;
	}
	@GetMapping("/admin/getAll1")
	public Collection<rate> getAllR()
	{
		return ratex.getAllRates(); 
	}
	// This Controler for massages 
			/*
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			M-S-G  */
	
	@PostMapping(
			  value = "/msg/add", consumes = "application/json", produces = "application/json")
	public massage addMsg(@RequestBody massage msg)
	{
		massage n = new massage();
		System.out.println(msg);	
		n.setName(msg.getName());
		n.setEmail(msg.getEmail());
		n.setMsg(msg.getMsg());
		n.setSubject(msg.getSubject());
		LocalDate currentdate = LocalDate.now();
		n.setDate(currentdate+"");
		income.addMsg(n);
	    return n;
	}
	@GetMapping("/msgs")
	public Collection<massage> getAllM()
	{
		return income.getAllUsers();
	}
}
