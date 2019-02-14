package com.lichee.thrift.example.server;

import com.lichee.thrift.example.person.DataException;
import com.lichee.thrift.example.person.Person;
import com.lichee.thrift.example.person.PersonService;
import org.apache.thrift.TException;

public class PersonServiceImpl implements PersonService.Iface {

    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {

        System.out.println("getPersonByUsername Got Client Param: " + username);
        Person person = new Person();
        person.setUsername("张三");
        person.setAge(18);
        person.setMarried(false);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {

        System.out.println("savePerson Got Client Param: ");
        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
