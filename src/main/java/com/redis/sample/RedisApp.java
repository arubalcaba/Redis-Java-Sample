package com.redis.sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.BinaryJedis;
import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class RedisApp 
{
    public static void main( String[] args ) throws IOException, ClassNotFoundException
    {
        System.out.println( "Hola Mundo!" );
        Jedis jedis = new Jedis("localhost");
        jedis.set("taco", "El Taco Grande En La Casa!");
        String value = jedis.get("taco");
        
        System.out.println(value);
        
        Employee employee = new Employee();
        employee.setEmployeeName("Andrew");
        employee.setEmployeeNumber("11");
        String phoneNumberOne = "567-897-6789";
        String phoneNumberTwo = "456-098-6789";
        List<String> phoneNumberList = new ArrayList<String>();
        phoneNumberList.add(phoneNumberTwo);
        phoneNumberList.add(phoneNumberOne);
        employee.setEmployeePhoneNumber(phoneNumberList);
        
       jedis.set(ObjectSerializer.serialize(employee), ObjectSerializer.serialize(employee));
       
       byte[] employeeKey = ObjectSerializer.serialize(employee);
       
       employee = null;
       employee = (Employee)ObjectSerializer.deserialize(jedis.get(employeeKey));
       System.out.println(employee.getEmployeeName());
        
    }
}
