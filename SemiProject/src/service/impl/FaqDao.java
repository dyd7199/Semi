package service.impl;

import java.sql.Connection;

import dto.Faq;

public interface FaqDao {

	Faq getData(Connection conn);

}
