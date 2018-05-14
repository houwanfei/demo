package com.example.demo.test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestNameParameter {
    public static void main(String[] args){
        String insertSql = "INSERT INTO quota_change_log"+
                "(serialNo,ObjectType,ContractNo,ApplyAmount,Amount,businessType,Customerid,CustomerName,CustomerCertID,startDate,EffiectivePeriod,applyDate,Remark) " +
                "VALUES(:serialNo,:ObjectType,:ContractNo,:ApplyAmount,:Amount,:businessType,:Customerid,:CustomerName,:CustomerCertID,:startDate,:EffiectivePeriod,:applyDate,:Remark)";
        String regex = ":\\w+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(insertSql);

        Map<String, Integer> indexMap = new HashMap<String, Integer>();

        int index = 1;
        while (m.find()){
            //System.out.println(m.group(0));
            String key = m.group(0);
            System.out.println(key.substring(1,key.length()));
            indexMap.put(key.substring(1,key.length()), index++);
        }

        System.out.println(insertSql.replaceAll(regex, "?"));
    }
}
