package com.employee.SecondSbApp.repo;


	import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.SecondSbApp.model.Blog;
@Repository
	public interface BlogRepository extends JpaRepository<Blog, Long> {
	}

