package CloudCourse.service.impl;

import CloudCourse.HBaseSearch.SysMap;
import CloudCourse.service.ErrorService;
import CloudCourse.service.model.ErrorModel;
import CloudCourse.spark.DateTransform;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ErrorServiceImpl implements ErrorService {
  @Override
  public List<ErrorModel> findAllErrorData(String eId) throws IOException {
    List<ErrorModel> errorModels = new ArrayList<>();
    Configuration configuration = HBaseConfiguration.create();
    Connection connection = ConnectionFactory.createConnection(configuration);
    //建立表的连接
    Table table = connection.getTable(TableName.valueOf("error"));
    SysMap sysmap = new SysMap();
    ErrorModel errorModel = new ErrorModel();
    //创建一个空的Scan实例
    Scan scan = new Scan();
    //在行上获取遍历器
    ResultScanner scanner = table.getScanner(scan);
    //打印行的值
    DateTransform dateTransform = new DateTransform();
    for(Result res : scanner){
      errorModel.setEid(sysmap.resultMapToRecord(res).getEid());
      errorModel.setTime(dateTransform.DateTransform(String.valueOf(sysmap.resultMapToRecord(res).getTime())));
      errorModel.setAddress(sysmap.resultMapToRecord(res).getAddress());
      errorModel.setLatitude(sysmap.resultMapToRecord(res).getLatitude());
      errorModel.setLongitude(sysmap.resultMapToRecord(res).getLongitude());
      errorModels.add(errorModel);
    }
    return errorModels;
  }
}
