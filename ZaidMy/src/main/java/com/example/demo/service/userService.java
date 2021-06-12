package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo.DOA.RepoCourse;
import com.example.demo.models.user;

import antlr.collections.List;

@Service
public class userService implements RepoCourse{

	@Autowired
	private RepoCourse repos;
	
	public user adduser(user a) {
		return repos.save(a);
	}
	
	public Collection<user> getAllUsers(){
		return repos.findAll();
	}
	
	public user findById(int id) {
		 for(int i=0 ; i < repos.findAll().size()+1; i++) {
			 if(repos.findAll().get(i).getID() == id) {
				 return repos.findAll().get(i);
			 }
		 }
		 return null;
	}
	
	
	public boolean foundspecial(int id) {
		for(int i=0 ; i < repos.findAll().size(); i++) {
			 if(repos.findAll().get(i).getSpecial_id() == id) {
				  return true;
			 }
		 }
		return false;
	}
	

	public boolean foundem(String id) {
		for(int i=0 ; i < repos.findAll().size(); i++) {
			 if(repos.findAll().get(i).getEmail().equals(id)) {
				  return true;
			 }
		 }
		return false;
	}
	public String maleandfemale() {
		int count = 0 ;
		for(int i=0 ; i < repos.findAll().size(); i++) {
			 if(repos.findAll().get(i).getGender().equals("Male")) {
				  count++;
			 }
		 }
		return count+"kk"+(repos.findAll().size()-count);
	}
	
	public boolean foundname(String id) {
		for(int i=0 ; i < repos.findAll().size(); i++) {
			 if(repos.findAll().get(i).getUsername().equals(id)) {
				  return true;
			 }
		 }
		return false;
	}
	
	public boolean foundSpecial(int id) {
		for(int i=0 ; i < repos.findAll().size(); i++) {
			 if(repos.findAll().get(i).getSpecial_id() == id) {
				  return true;
			 }
		 }
		return false;
	}
	public boolean Login1(String a, String b) {
		for(int i=0 ; i < repos.findAll().size(); i++) {
			 if(repos.findAll().get(i).getEmail().equals(a)) {
				  if(repos.findAll().get(i).getPassword().equals(b)) {
					  return true;
				  }
			 }
		 }
		return false;
	}
	
	public boolean Login2(String a, String b) {
		int x = Integer. parseInt(a);
		for(int i=0 ; i < repos.findAll().size(); i++) {
			 if(repos.findAll().get(i).getSpecial_id() == x) {
				  if(repos.findAll().get(i).getPassword().equals(b)) {
					  return true;
				  }
			 }
		 }
		return false;
	}
	
	public int getidbyid(String a) {
		int x = Integer. parseInt(a);
		for(int i=0 ; i < repos.findAll().size(); i++) {
			 if(repos.findAll().get(i).getSpecial_id() == x) {
				  return repos.findAll().get(i).getID();
			 }
		 }
		return -1;
	}
	
	public int getidbyem(String a) {
		for(int i=0 ; i < repos.findAll().size()+1; i++) {
			 if(repos.findAll().get(i).getEmail().equals(a)) {
				  return repos.findAll().get(i).getID();
			 }
		 }
		return -1;
	}
	public void delete(user a) {
		repos.delete(a);
	}
	
	public void removeUser(int x) {
		repos.deleteById(x);
	}
	
	public void removAll() {
		repos.deleteAll();
	}
	
	public user updateUsr(user x) {
		return repos.save(x);
	}

	@Override
	public java.util.List<user> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.List<user> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.List<user> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends user> java.util.List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends user> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<user> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public user getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends user> java.util.List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends user> java.util.List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<user> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends user> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<user> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends user> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends user> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends user> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends user> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends user> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

}
