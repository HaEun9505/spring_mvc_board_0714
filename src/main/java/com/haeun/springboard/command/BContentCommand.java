package com.haeun.springboard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.haeun.springboard.dao.BDao;
import com.haeun.springboard.dto.BDto;

public class BContentCommand implements BCommand {
	
	//BCommand 클래스에서 만든 추상메소드 오버라이딩
	@Override
	public void execute(Model model) {	// request 객체가 들어있음
		
		//안에 든 값을 뽑아냄(arrayList와 비슷)
		Map<String, Object> map = model.asMap();
		//model객체로 전달받은 데이터를 request객체로 받기
		HttpServletRequest request = (HttpServletRequest)map.get("request");	
		
		String bid = request.getParameter("bid");
		
		
		BDao dao = new BDao();
		BDto dto = dao.contentView(bid);
		
		//BDto로 받아서 model 객체에 탑재
		model.addAttribute("dto", dto);
	}

}