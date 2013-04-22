package com.redis.sample;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.BinaryJedis;
import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hola Mundo!" );
        Jedis jedis = new Jedis("localhost");
        jedis.set("foo", "bar");
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
        
        jedis.set(employee.toString().getBytes(), employee.toString().getBytes());
        
        byte[] employeeBytes = jedis.get(employee.toString().getBytes());
        
        
        employee.toString().getBytes();
        
    }
}
