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
import com.example.demo.DOA.Times;
import com.example.demo.models.Time;

import antlr.collections.List;

@Service
public class timeservice implements Times{

	@Autowired
	private Times time;
	
	public Time addTime(Time a) {
		return time.save(a);
	}
	
	public Collection<Time> getAllUsers(){
		return time.findAll();
	}
	
	public void delete(Time a) {
		time.delete(a);
	}
	
	public void removeUser(int x) {
		time.deleteById(x);
	}
	
	public void removAll() {
		time.deleteAll();
	}
	public String getone(String x) {
		Time t = getSpecial(x);
		return t.getTotal()+"";
	}
	public Time getSpecial(String x){
		for(int i=time.findAll().size(); i>=0; i--) {
			if(time.findAll().get(i).getName().trim().equals(x.trim())) {
				return time.findAll().get(i);
			}
		}
		return null;
	}
	public ArrayList<Time> getTimesForMe(String x){
		ArrayList<Time> arr = new ArrayList<Time>();
		for(int i=0; i<time.findAll().size(); i++) {
			if(time.findAll().get(i).getName().trim().equals(x.trim())) {
				arr.add(time.findAll().get(i));
			}
		}
		return arr;
	}
	public String times(String x) {
		ArrayList<Time> arr = getTimesForMe(x);
		String res = "";
		double sum = 0;
		for(int i=0; i<arr.size(); i++) {
			if(i == arr.size()-1) {
				res += arr.get(i).getDate()+"newtr";
				res += arr.get(i).getStart()+"newtr";
				res += arr.get(i).getFinish()+"newtr";
				res += arr.get(i).getTotal()+"newtr";
				double f = arr.get(i).getTotal();
				sum = sum + (f/2);
			}
			else {
			res += arr.get(i).getDate()+"newtr";
			res += arr.get(i).getStart()+"newtr";
			res += arr.get(i).getFinish()+"newtr";
			res += arr.get(i).getTotal()+"newtr";
			sum += arr.get(i).getTotal();
			double f = arr.get(i).getTotal();
			sum = sum + (f/2);
			res += "newrr";
			}
		}
		return res+"wowww"+sum;
	}
	public ArrayList<Time> getTimesForMestr(String x){
		ArrayList<Time> arr = new ArrayList<Time>();
		for(int i=0; i<time.findAll().size(); i++) {
			if(time.findAll().get(i).getName().trim().equals(x.trim())) {
				arr.add(time.findAll().get(i));
			}
		}
		return arr;
		
	}

	@Override
	public java.util.List<Time> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.List<Time> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.List<Time> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Time> java.util.List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Time> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Time> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Time getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Time> java.util.List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Time> java.util.List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Time> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Time> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Time> findById(Integer id) {
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
	public void deleteAll(Iterable<? extends Time> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Time> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Time> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Time> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Time> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}


}
