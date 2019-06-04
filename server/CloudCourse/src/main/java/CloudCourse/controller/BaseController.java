package CloudCourse.controller;

import CloudCourse.error.EmProjectError;
import CloudCourse.error.ProjectException;
import CloudCourse.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {
    public static final String  CONTENT_TYPE_FORMED = "application/x-www-form-urlencoded";


    //定义exceptionhandler解决未被controller层吸收的exception
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception ex){

        Map<String,Object> repsponseData = new HashMap<>();
        if(ex instanceof ProjectException) {
            ProjectException businessException = (ProjectException)ex;
            repsponseData.put("errCode",businessException.getErrCode());
            repsponseData.put("errMsg",businessException.getErrMsg());
        }else{
            repsponseData.put("errCode",EmProjectError.UNKNOWN_ERROR.getErrCode());
            repsponseData.put("errMsg",EmProjectError.UNKNOWN_ERROR.getErrMsg());
        }
        return CommonReturnType.create(repsponseData,"fail");
    }
}
