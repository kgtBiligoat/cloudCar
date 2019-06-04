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


}
