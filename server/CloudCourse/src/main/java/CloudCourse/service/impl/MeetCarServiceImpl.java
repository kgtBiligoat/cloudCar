package CloudCourse.service.impl;

import CloudCourse.hbase.HBaseConf;
import CloudCourse.service.MeetCarService;
import CloudCourse.service.model.MeetCarModel;
import CloudCourse.spark.CarMap;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MeetCarServiceImpl implements MeetCarService {
  @Override
  public List<MeetCarModel> searchMeetCar(String eId) throws IOException {
    String tablename = "MeetCount";
    Connection connection = HBaseConf.getConnection();
    Admin admin = connection.getAdmin();
    TableName name = TableName.valueOf(tablename);
    List<MeetCarModel> meetCarModels = new ArrayList<>();
    MeetCarModel meetCarModel = new MeetCarModel();
    if (admin.tableExists(name)) {
      TableName tableName = TableName.valueOf(Bytes.toBytes(tablename));
      Table table = connection.getTable(tableName);
      CarMap map = new CarMap();

      Scan scan = new Scan();
      Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL, new RegexStringComparator(eId));
      scan.setFilter(filter);
      ResultScanner scanner = table.getScanner(scan);
      for (Result result : scanner) {
        meetCarModel.seteId1(map.resultMapToRecord(result).geteId1());
        meetCarModel.seteId2(map.resultMapToRecord(result).geteId2());
        meetCarModel.setCount(map.resultMapToRecord(result).getCount());
        meetCarModels.add(meetCarModel);
      }
    }
    return meetCarModels;
  }
}
