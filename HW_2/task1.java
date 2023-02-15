/* 1 . Дана строка sql-запроса "select * from students where ". 
Сформируйте часть WHERE этого запроса, используя StringBuilder. 
Данные для фильтрации приведены ниже в виде json строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"} */

package HW_2;

import java.util.HashMap;
import java.util.Map;

public class task1 {
    public static void main(String[] args) {
        String startSQL = "select * from students where ";
        Map<String, String> param = new HashMap<String, String>();
        param.put("name", "Ivanov");
        param.put("country", "Russia");
        param.put("city", "Moscow");
        param.put("age", "null");
        
        String result = set_where(startSQL, param);
        System.out.println(result);
    }

    private static String set_where(String startSQL, Map<String, String> param) {
        StringBuilder sql = new StringBuilder();
        sql.append(startSQL);
        for (Map.Entry<String, String> item : param.entrySet()){
            if (item.getValue() != "null") {
                sql.append(item.getKey()).append(" = ");
                sql.append(item.getValue()).append(" and ");
            }
        }
        sql.setLength(sql.length() - 4);
        sql.append(";");

        return sql.toString();
    }
}
