package CloudCourse.controller;


import CloudCourse.controller.viewobject.CountVO;
import CloudCourse.controller.viewobject.ErrorVO;
import CloudCourse.response.CommonReturnType;
import CloudCourse.service.CountService;
import CloudCourse.service.model.CountModel;
import CloudCourse.service.model.ErrorModel;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
//@CrossOrigin(origins = {"*"},allowCredentials = "true")
public class CountController {

  @Autowired
  CountService countService;

  @RequestMapping(value = "/count",method = {RequestMethod.GET})
  @ResponseBody
  public JSONObject countCar(@RequestParam(name = "placeId")Integer placeId) throws IOException {
    List<CountModel> countModels = countService.countCar(placeId );
    JSONObject jso = (JSONObject) JSONObject.stringToValue(countModels.toArray().toString());
    return jso;
  }

  private CountVO convertVOFromModel(CountModel countModel){
    if(countModel == null){
      return null;
    }
    CountVO countVO = new CountVO();
    BeanUtils.copyProperties(countModel,countVO);
    return countVO;
  }
}
