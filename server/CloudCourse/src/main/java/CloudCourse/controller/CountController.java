package CloudCourse.controller;


import CloudCourse.response.CommonReturnType;
import CloudCourse.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
@CrossOrigin(origins = {"*"},allowCredentials = "true")
public class CountController extends BaseController {

  @Autowired
  private CountService countService;

  @RequestMapping(value = "/record",method = {RequestMethod.GET})
  @ResponseBody
  public String countCar(){
    System.out.println(1111);
    return "hello world";
  }

}
