//package CloudCourse.controller;
//
//import CloudCourse.response.CommonReturnType;
//import CloudCourse.service.CountService;
//import CloudCourse.service.RecordService;
//import CloudCourse.service.model.CountModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//@RequestMapping("")
//@CrossOrigin(origins = {"*"},allowCredentials = "true")
//public class RecordController extends BaseController {
//
//  @Autowired
//  private RecordService recordService;
//
//  @RequestMapping(value = "/record",method = {RequestMethod.GET})
//  @ResponseBody
//  public CommonReturnType recordSearch(){
//    return CommonReturnType.create(null);
//  }
//
//}
