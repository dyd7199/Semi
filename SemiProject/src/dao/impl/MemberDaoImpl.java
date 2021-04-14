package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.MemberDao;
import dto.Member;

public class MemberDaoImpl implements MemberDao {

	PreparedStatement ps = null;
	ResultSet rs = null;


	@Override
	public Member selectMemberByUserid(Connection conn, Member member) {
		String sql = "";
		sql += "SELECT * FROM user_table";
		sql += " WHERE 1=1 AND userid = ?";

		Member res = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getUserid());
			rs = ps.executeQuery();

			while(rs.next()) {
				res = new Member();
				res.setUserid(rs.getString("userid"));
				res.setUserpw(rs.getString("userpw"));
				res.setNick(rs.getString("nick"));
			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}



		return res;
	}


	@Override
	public int selectCntMemberUseridUserpw(Connection conn, Member member) {

		String sql="";

		sql += "SELECT count(*) cnt FROM user_table";
		sql += " WHERE userid = ? AND userpw = ?";

		int res = 0;


		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getUserid());
			ps.setString(2, member.getUserpw());
			rs = ps.executeQuery();

			while(rs.next()) {
				res = rs.getInt("cnt");
			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}


		System.out.println(res);

		return res;
	}

}
