package com.test2.test2.operations;

import com.test2.test2.entity.Test2Entity;
import com.test2.test2.repository.Test2Repo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Operations2 {
    Scanner sc=new Scanner(System.in);
    @Autowired
    private Test2Repo repo2;

    public void add(){
        Test2Entity t=new Test2Entity();

        boolean b=true;
        while(b){
        System.out.println("give name");
        t.setName(sc.next());
        System.out.println("give idd");
        t.setIdd(sc.nextInt());
        System.out.println("give country");
        t.setCountry(sc.next());
        repo2.save(t);
        System.out.println("if you want to give another record type y otherwise click any");
        String s=sc.next();
        if(s.equalsIgnoreCase("y")){
            b=true;
        }
        else{
            b=false;
        }
        }
    }
    public void sorting(){
//         repo2.findAll(Sort.by(Sort.Direction.ASC,"country","idd")).stream().forEach(System.out::println);
     List<Test2Entity>list=   repo2.findAll(Sort.by(Sort.Direction.ASC,"idd","country"));
     list.stream().forEach(System.out::println);

    }
    public void     select(){
        List<Test2Entity> list=repo2.findAll();
        list.stream().forEach(System.out::println);
//        repo2.getData().stream().forEach(System.out::println);
    }
    public void     inserting(){
        repo2.getInsertedData(17,"afg","md");
        repo2.findAll(Sort.by(Sort.Direction.DESC,"country","name")).stream().forEach(System.out::println);
    }
public void deleting(){
        repo2.getDeleted(2);
}
public void updatingNamedQuery(){
        repo2.getUpdated("smith","pat");
}
    public void pagination(){
        Page<Test2Entity> page=repo2.findAll(Pageable.ofSize(3));
        page.getContent().stream().forEach(System.out::println);
      Page<Test2Entity>page1=  repo2.findAll(PageRequest.of(0,4,Sort.by(Sort.Direction.DESC,"name")
       ));
      List<Test2Entity>list=page.getContent();
      list.stream().forEach(System.out::println);
//       repo2.findAll(PageRequest.of(0,4,Sort.by(Sort.Direction.DESC,"name")
//       )).getContent().stream().forEach(System.out::println);
    }
    public void Named(){
        repo2.getNamedData("ind","a").stream().forEach(System.out::println);
    }
    @Transactional
    public void m(){

System.out.println(repo2.deleteByName("x"));
    }
    public void update(){
        Optional<Test2Entity> opt=repo2.findById(1);
        if(opt.isPresent()){
            Test2Entity obj=opt.get();
            obj.setName("z");
            repo2.save(obj);
        }
    }

    public void selectJPQL(){
        repo2.selectingJPQL().stream().forEach(System.out::println);
    }
}
