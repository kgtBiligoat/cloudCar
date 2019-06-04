package CloudCourse.controller;


import CloudCourse.response.CommonReturnType;
import CloudCourse.service.ErrorService;
import CloudCourse.service.model.CountModel;
import CloudCourse.service.model.ErrorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("")
@CrossOrigin(origins = {"*"},allowCredentials = "true")
public class ErrorController extends BaseController {

  @Autowired
  private ErrorService errorService;

  @RequestMapping(value = "/record",method = {RequestMethod.GET})
  @ResponseBody
  public CommonReturnType countCar(){
    List<ErrorModel> listErrorModel = errorService.findAllErrorData("s");
    return CommonReturnType.create(listErrorModel);
  }
}
