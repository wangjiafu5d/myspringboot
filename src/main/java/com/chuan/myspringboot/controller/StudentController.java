package com.chuan.myspringboot.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chuan.myspringboot.bean.Student;

@RestController
public class StudentController {

	@Autowired
	private RedisTemplate redisTemplate;
	@PostMapping("/set")
	public void set(@RequestBody Student student) {
		System.out.println(student.getScore());
		redisTemplate.opsForValue().set("student", student);
		}
	@RequestMapping(("/get/{key}"))
	@ResponseBody
	@Cacheable("userCache")
	public Student get(@PathVariable("key") String key) {
		Student  s = (Student) redisTemplate.opsForValue().get("student");
		System.out.println(s==null);
		System.out.println(s.toString());
//		Student s2 = new Student(3,"李四",99.9,new Date());
//		return s2;
		return (Student) redisTemplate.opsForValue().get("student");
	}
	@DeleteMapping("/delete/{key}")
	@CacheEvict("userCache")
	public boolean delete(@PathVariable("key") String key) {
		redisTemplate.delete(key);
		return !redisTemplate.hasKey(key);
	}
}
