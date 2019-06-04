package CloudCourse.controller;


import CloudCourse.response.CommonReturnType;
import CloudCourse.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class CountController {

  @Autowired
  private CountService countService;

  @RequestMapping(value = "/record",method = {RequestMethod.GET})
  @ResponseBody
  public String countCar(){
    System.out.println(1111);
    return "hello world";
  }

}
