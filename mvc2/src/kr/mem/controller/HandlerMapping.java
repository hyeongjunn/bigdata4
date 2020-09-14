package kr.mem.controller;

import java.util.HashMap;

import kr.mem.pojo.Controller;
import kr.mem.pojo.MemberContentController;
import kr.mem.pojo.MemberDeleteController;
import kr.mem.pojo.MemberInsertController;
import kr.mem.pojo.MemberInsertFormController;
import kr.mem.pojo.MemberListController;
import kr.mem.pojo.MemberUpdateController;

public class HandlerMapping {

	// HashMap을 가지고 있어야 함.

	// list.do(Key) >> MemberListController(Value)
	private HashMap<String, Controller> mappings; // 필드값.

	public HandlerMapping() {

		mappings = new HashMap<String, Controller>();
		initMap(); // 아 키와 밸류값을 넣어주는거구나.

	}

	// ★★★★★★★★★★★★★★★★★
	private void initMap() {
		try {
			mappings.put("/list.do", new MemberListController());
			mappings.put("/insert.do", new MemberInsertController());
			mappings.put("/insertForm.do", new MemberInsertFormController());
			mappings.put("/delete.do", new MemberDeleteController());
			mappings.put("/content.do", new MemberContentController());
			mappings.put("/update.do", new MemberUpdateController());
			
			// pojo녀석들 걸어주기.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Controller getController(String key) {

		return mappings.get(key); // frontcontroller에서 받는 키 값.

	}

}
