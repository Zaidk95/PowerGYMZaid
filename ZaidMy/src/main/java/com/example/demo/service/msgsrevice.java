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
import com.example.demo.DOA.repomsg;
import com.example.demo.models.massage;

import antlr.collections.List;

@Service
public class msgsrevice implements repomsg{

	@Autowired
	private repomsg msg;
	
	public massage addMsg(massage a) {
		return msg.save(a);
	}
	
	public Collection<massage> getAllUsers(){
		return msg.findAll();
	}
	
	public void delete(massage a) {
		msg.delete(a);
	}
	
	public void removeUser(int x) {
		msg.deleteById(x);
	}
	
	public void removAll() {
		msg.deleteAll();
	}

	@Override
	public java.util.List<massage> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.List<massage> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.List<massage> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends massage> java.util.List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends massage> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<massage> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public massage getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends massage> java.util.List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends massage> java.util.List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<massage> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends massage> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<massage> findById(Integer id) {
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
	public void deleteAll(Iterable<? extends massage> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends massage> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends massage> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends massage> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends massage> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}


}
