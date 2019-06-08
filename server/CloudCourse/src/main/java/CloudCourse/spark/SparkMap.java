package CloudCourse.spark;

import CloudCourse.service.model.RecordModel;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.List;

public class SparkMap {
    public RecordModel resultMapToRecord(Result result){
        RecordModel record = new RecordModel();
        //1.分解行键
        String rowKey = Bytes.toString(result.getRow());
        record.setPlaceId(Integer.parseInt(rowKey));

        //2.解析所有的列信息
        List<Cell> cellList =  result.listCells();
        for(Cell cell : cellList){
            String qualifier = Bytes.toString(CellUtil.cloneQualifier(cell));
            String value = Bytes.toString(CellUtil.cloneValue(cell));
            switch(qualifier){
                case "address" : record.setAddress(value); break;
                case "longitude" : record.setLongitude(Double.parseDouble(value)); break;
                case "latitude" : record.setLatitude(Double.parseDouble(value)); break;
                case "count" : record.setCount(Integer.parseInt(value)); break;
            }

        }
        return record;
    }
}
