package com.hello.repository;

import com.spring.prac.domain.Member;
import com.spring.prac.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStroe();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("test");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("test1");
        repository.save(member2);

        Member find = repository.findByName("test").get();
        assertThat(find).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("test1");
        repository.save(member1);

        Member member= new Member();
        member.setName("test2");
        repository.save(member);

        List<Member> members = repository.findAll();
        assertThat(members.size()).isEqualTo(2);
    }

}