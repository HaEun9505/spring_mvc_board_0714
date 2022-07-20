package com.haeun.springboard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.haeun.springboard.dao.BDao;
//글쓰기
public class BWriteCommand implements BCommand {
	//BCommand 클래스에서 만든 추상메소드 오버라이딩
	@Override
	public void execute(Model model) {
		
		//Map<key,value> - key:필드명, value:값
		//map 안에 든 값을 뽑아냄(arrayList와 비슷)
		Map<String, Object> map = model.asMap();
		//model객체로 전달받은 데이터를 request객체로 받기
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BDao dao = new BDao();		
		//dao 메소드
		dao.write(bname, btitle, bcontent);
	}

}