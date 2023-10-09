package com.github.goodfatcat.t1consaltingtestproblem.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.goodfatcat.t1consaltingtestproblem.dto.LineRequest;
import com.github.goodfatcat.t1consaltingtestproblem.service.FinderRepetitionService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class FindRepetitionsController {
	
	private FinderRepetitionService finderRepetitionService;
	
	@GetMapping("/findRepetitionsInLine")
	public ResponseEntity<Map<String, Integer>> findRepetitions(@RequestBody LineRequest lineRequest) {
		Map<String, Integer> repetitions = finderRepetitionService.findRepetitions(lineRequest.getLine());
		return ResponseEntity.ok(repetitions);
	}
}
