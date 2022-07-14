package com.haeun.springboard.command;

import org.springframework.ui.Model;

public interface BCommand {
	//추상메소드(표준 규격 지정)	
	void execute(Model model);	// model을 통째로 불러옴
}
