package com.jxd.bookmanger.controller;

import com.alibaba.fastjson.JSONArray;
import com.jxd.bookmanger.model.Book;
import com.jxd.bookmanger.model.VoBook;
import com.jxd.bookmanger.service.IBookService;
import com.jxd.bookmanger.service.IBooktypeService;
import com.jxd.bookmanger.service.impl.BookServiceImpl;
import com.jxd.bookmanger.service.impl.BooktypeServiceImpl;
import com.mysql.cj.xdevapi.JsonArray;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.Cookie;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BookController
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/12
 * @Version 1.0
 */
@Controller
@SessionAttributes({"user"})
public class BookController {
    @Autowired
    IBookService bookService;


    @Autowired
    IBooktypeService booktypeService;

 /* private IBookService bookService = new BookServiceImpl();
  private IBooktypeService booktypeService = new BooktypeServiceImpl();*/

    @RequestMapping(value = "/AddServlet")
    public String addServlet(String booksname, String eitor, String puber, String pubdate,
                             String booknum, String bookpri, String typeno, Model model){
        Book book = new Book(booksname,eitor,puber,pubdate,Integer.parseInt(booknum),Double.parseDouble(bookpri),Integer.parseInt(typeno));
        String addmsg = "新增失败";
        if(bookService.addone(book)){
            addmsg = "新增成功";
        }
        model.addAttribute("addmsg",addmsg);
        return "booklist";
    }

    @RequestMapping(value = "/DelServlet")
    public String Del(String booknos,Model model){
        String[] strs = booknos.split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        String delmsg = "删除失败";
        if (bookService.del(nums)){
            delmsg = "删除成功";
        }
        model.addAttribute("delmsg",delmsg);
        return "booklist";
    }

    @RequestMapping(value = "/GetTypeServlet")
    @ResponseBody
    public List<VoBook>  GetType(){
        List<VoBook> list = booktypeService.getType();
        /*Map<Integer,Object> map = new HashMap<Integer, Object>();
        for (VoBook v :list) {
            map.put(v.getBookno(),v.getTypename());
        }*/
        return list;
    }

    @RequestMapping("/ListServlet")
    @ResponseBody
    public Map<String,Object> getList(String snakey,String type,String page,String limit){
        Integer typeno = null;
        if (type != null && !"".equals(type)){
          typeno = Integer.parseInt(type);
        }
        List<VoBook> list = bookService.querymore(snakey,typeno,Integer.parseInt(limit),Integer.parseInt(page));
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code",0); result.put("msg","");
        result.put("count",list.size());
        result.put("data",list);
        return result;
    }

    @RequestMapping("/LoginServlet")
    public String login(String uname,String pwd,Model model){
        if ("admin".equals(uname) && "123".equals(pwd)) {
            model.addAttribute("user",uname);
            return "booklist";
        } else {
            model.addAttribute("msg", "登录失败");
            return "booklogin";
        }
    }

    @RequestMapping("/UpFirstServlet")
    public String Up(String bookno,Model model){
        Integer bookno1 = Integer.parseInt(bookno);
        Book book = bookService.queryone(bookno1);
        model.addAttribute("book",book);
        return "bookup";
    }

    @RequestMapping("/UpSecondServlet")
    public String UpTwo(String bookno,String booksname,String eitor,String puber,
                        String pubdate,String booknum,String bookpri,String typeno,Model model){
        Book book = new Book(Integer.parseInt(bookno),booksname,eitor,puber,pubdate,Integer.parseInt(booknum),Double.parseDouble(bookpri),Integer.parseInt(typeno));
        String upmsg = "修改失败";
        if(bookService.up(book)){
            upmsg = "修改成功";
        }
        model.addAttribute("upmsg",upmsg);
        return "booklist";
    }

    /*
     * 如果希望以流的方式响应给前台就要添加@ResponsBody
     *
     * */
    @RequestMapping(value = "/bookaddone")
    public String sayHello(){
        return "bookadd";

    }




}
