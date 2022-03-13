package com.semi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semi.dao.DuoDAO;
import com.semi.dto.Duo;
import com.semi.dto.Member;

@Service
public class DuoServiceImpl implements DuoService{
	@Autowired
	DuoDAO duoDAO;

	@Override
	public void insertDuo(Duo duo, Member mem) throws Exception {
		if(mem.getMem_email_id()!=null) {
			duo.setDuo_email_id(mem.getMem_email_id());
		} else {
			duo.setDuo_email_id(mem.getMem_kakao_id());
		}
		duoDAO.insertDuo(duo);
	}

}
