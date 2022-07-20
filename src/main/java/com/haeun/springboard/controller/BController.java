package com.haeun.springboard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.haeun.springboard.command.BCommand;
import com.haeun.springboard.command.BContentCommand;
import com.haeun.springboard.command.BDeleteCommand;
import com.haeun.springboard.command.BListCommand;
import com.haeun.springboard.command.BModifyCommand;
import com.haeun.springboard.command.BReplyCommand;
import com.haeun.springboard.command.BReplyViewCommand;
import com.haeun.springboard.command.BWriteCommand;
//스프링 컨테이너 설정 파일
@Controller
public class BController {	//command 호출
	
	BCommand command;
	
	@RequestMapping(value = "/write_form")	//write_form 요청이 오면
	
	public String write_form() {
		
		return "write_form";	//write_form 페이지 반환
	}
	
	@RequestMapping(value = "/write")	//submit 버튼을 누르면 "write" 요청
	//request(파라미터 값 받을 객체),Model(데이터를 담아 view로 전달하는 객체)
	public String write(HttpServletRequest request, Model model) {
		//request란 이름으로 request객체를 model 객체에 실어서 command에 전달
		model.addAttribute("request", request);
		
		command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";	
		//새로고침해서 list페이지로(list 요청을 다시 돌려서 보여줌)
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model) {
		//list에서 빈 model 받기
		command = new BListCommand();
		command.execute(model);//model 에 list(ArrayList<BDto> dtos)가 탑재
		
		return "list";	//listCommand를 통해서 list가 보여짐
	}
	
	@RequestMapping(value = "/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		//request 객체를 model 객체에 실어서 command에 전달
		model.addAttribute("request", request);
		
		command = new BContentCommand();
		//DB에서 바뀐 내용 실행해줌
		command.execute(model);
		
		return "content_view";
	}
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request, Model model) {
		//request 객체를 model 객체에 실어서 command에 전달
		model.addAttribute("request", request);
		
		command = new BDeleteCommand();
		//DB에서 바뀐 내용 실행해줌
		command.execute(model);
		
		return "redirect:list";		//새로고침(요청을 다시 돌려서 보여줌)
	}
	
	@RequestMapping(value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		
		//request 객체를 model 객체에 실어서 command에 전달
		model.addAttribute("request", request);
		
		command = new BModifyCommand();
		//DB에서 바뀐 내용 실행해줌
		command.execute(model);
		
		return "redirect:list";		//새로고침(요청을 다시 돌려서 보여줌)
	}
	
	@RequestMapping(value = "/reply_view")	//덧글을 달 수 있는 폼
	public String reply_view(HttpServletRequest request, Model model) {
		
		//request 객체를 model 객체에 실어서 command에 전달
		model.addAttribute("request", request);
		
		command = new BReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	@RequestMapping(value = "/reply")
	public String reply(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BReplyCommand();
		command.execute(model);
		
		return "redirect:list";		//새로고침(요청을 다시 돌려서 보여줌)
	}
	
}