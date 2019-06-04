package CloudCourse.spark;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MeetCar{
    private String getEId()
    {
        String EId;
        try {
            System.out.println("请输入EId：");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            EId=in.readLine();
        }
        catch (Exception e)
        {
            System.out.println("输入错误!");
            String a = getEId();
            return a;
        }
        return EId;
    }


    @ResponseBody
    public void Filtra() throws IOException {

        JSONArray array =new JSONArray();
        String i = getEId();
        String tablename = "MeetCount";
        Connection connection = HBaseConf.getConnection();
        Admin admin = connection.getAdmin();
        TableName name = TableName.valueOf(tablename);
//        List list = new ArrayList();
        if (admin.tableExists(name)) {
            try {
                TableName tableName = TableName.valueOf(Bytes.toBytes(tablename));
                Table table = connection.getTable(tableName);
                CarMap map = new CarMap();


                Scan scan = new Scan();
                Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL, new RegexStringComparator(i));
                scan.setFilter(filter);
                ResultScanner scanner = table.getScanner(scan);


                for (Result result : scanner) {
//                    list.add(map.resultMapToRecord(result).getEid());
//                    list.add(map.resultMapToRecord(result).getEid2());
//                    list.add(map.resultMapToRecord(result).getCount());
                    JSONObject obj=new JSONObject();
                    obj.put("eid", map.resultMapToRecord(result).getEid());
                    obj.put("eid2", map.resultMapToRecord(result).getEid2());
                    obj.put("count", map.resultMapToRecord(result).getCount());
//                  System.out.println(list);

//                  list.clear();
                }

            } catch (IllegalArgumentException | JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Table doesn't exist!");
        }
    }

    public static void main(String[] args) {
        try {
            MeetCar meet = new MeetCar();
            while (true){
                meet.Filtra();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
