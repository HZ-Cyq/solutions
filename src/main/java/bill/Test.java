package bill;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author chenyuqun
 * @date 2021/7/29 2:14 下午
 */
public class Test {
//    public static List<Hotel> csv() {
//        Hotel hotel = null;
//        //生成CsvReader对象，以，为分隔符，GBK编码方式
//        CsvReader r = null;
//        try {
//            List<Hotel> hotels = new ArrayList<>();
//            String csvFilePath = "E:\\AvailHotelSummary_V0.csv";
//            r = new CsvReader(csvFilePath, '|', Charset.forName("UTF-8"));
//            //读取表头
//            r.readHeaders();
//            //逐条读取记录，直至读完
//            while (r.readRecord()) {
//                hotel = new Hotel();
//                hotel.setHotelId(r.get(0));
//                hotel.setAddress(r.get("Address"));
//                hotel.setAddressCn(r.get("Address_CN"));
//                hotel.setAirportCode(r.get("AirportCode"));
//                hotel.setCityCode(r.get("CityCode"));
//                hotel.setCityName(r.get("CityName"));
//                hotels.add(hotel);
//            }
//            r.close();
//            return hotels;
//        } catch (Exception e) {
//            log.info("【航班信息】批量导入csv异常!", e);
//            return null;
//        } finally {
//            r.close();
//        }
//    }

    public static void main(String[] args) throws IOException {
//        List<Hotel> csv = csv();
//        System.out.println(csv.size());
//        log.info("cvs结果：{}",JSONObject.toJSONString(csv.get(6)));
//        for ( Hotel c :csv ) {
//            System.out.println(c.getHotelId());
//        }
//        String srcPath = "/Users/playcrab/Downloads/alipay_record_20210729_1410_1.csv";
        String srcPath = "/Users/playcrab/Downloads/2.csv";
        String charset = StandardCharsets.UTF_8.toString();
        try (CSVReader csvReader = new CSVReaderBuilder(new BufferedReader(new InputStreamReader(new FileInputStream(new File(srcPath)), charset))).build()) {
            Iterator<String[]> iterator = csvReader.iterator();
            while (iterator.hasNext()) {
                Arrays.stream(iterator.next()).forEach(System.out::print);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
