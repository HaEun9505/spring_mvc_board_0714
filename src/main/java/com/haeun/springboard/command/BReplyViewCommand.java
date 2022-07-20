package com.haeun.springboard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.haeun.springboard.dao.BDao;
import com.haeun.springboard.dto.BDto;

public class BReplyViewCommand implements BCommand {

	@Override
	public void execute(Model model) {
		
		//map안의 값 가져오기(==ArrayList)
		Map<String, Object> map = model.asMap();
		//model객체로 전달받은 데이터를 request객체로 받기
		HttpServletRequest request = (HttpServletRequest)map.get("request");	
		
		String bid = request.getParameter("bid");
		
		
		BDao dao = new BDao();
		BDto dto = dao.replyView(bid);
		
		//BDto로 받아서 model 객체에 탑재
		model.addAttribute("dto", dto);

	}

}
