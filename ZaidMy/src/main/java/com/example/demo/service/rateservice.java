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
import com.example.demo.DOA.Raterepo;
import com.example.demo.DOA.RepoCourse;
import com.example.demo.models.rate;

import antlr.collections.List;

@Service
public class rateservice implements Raterepo{

	@Autowired
	private Raterepo ratex;
	
	public rate addReview(rate a) {
		return ratex.save(a);
	}
	
	public Collection<rate> getAllRates(){
		return ratex.findAll();
	}
	public String getReviews() {
		String res = "";
		ArrayList<rate> x = (ArrayList<rate>) getAllRates();
		for(int i = 0 ; i < x.size(); i++) {
			
			res += x.get(i).getUsername()+"newEE";
			res += x.get(i).getRating()+"newEE";
			res += x.get(i).getTitle()+"newEE";
			res += x.get(i).getDescripe()+"newEE";
			res += x.get(i).getDate()+"newEE";
			res += "newRR";
		}
		return res;
	}
	
	public ArrayList<rate> getMy(String h) {
		ArrayList<rate> x = (ArrayList<rate>) getAllRates();
		ArrayList<rate> w = new ArrayList<rate>();
		for(int i=0; i < x.size(); i++) {
			if(x.get(i).getUsername().trim().equals(h.trim())) {
				w.add(x.get(i));
			}
		}
		System.out.println(w.toString());
		return w;
	}
	public void delete(rate a) {
		ratex.delete(a);
	}
	
	public void removeReview(int x) {
		ratex.deleteById(x);
	}
	
	public void removAll() {
		ratex.deleteAll();
	}

	@Override
	public java.util.List<rate> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.List<rate> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.List<rate> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends rate> java.util.List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends rate> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<rate> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public rate getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends rate> java.util.List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends rate> java.util.List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<rate> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends rate> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<rate> findById(Integer id) {
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
	public void deleteAll(Iterable<? extends rate> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends rate> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends rate> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends rate> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends rate> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}


}
