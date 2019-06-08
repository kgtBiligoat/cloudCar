package CloudCourse.spark;

import CloudCourse.service.model.MeetCarModel;
import CloudCourse.service.model.RecordModel;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.List;

public class CarMap {
    public MeetCarModel resultMapToRecord(Result result){
        MeetCarModel record = new MeetCarModel();
        //1.分解行键
        String rowKey = Bytes.toString(result.getRow());
        record.seteId1(rowKey);

        //2.解析所有的列信息
        List<Cell> cellList =  result.listCells();
        for(Cell cell : cellList){
            String qualifier = Bytes.toString(CellUtil.cloneQualifier(cell));
            String value = Bytes.toString(CellUtil.cloneValue(cell));
            switch(qualifier){
                case "eid2" : record.seteId2(value); break;
                case "count" : record.setCount(Integer.parseInt(value)); break;
            }
        }
        return record;
    }
}
