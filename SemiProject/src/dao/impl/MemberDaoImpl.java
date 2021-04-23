package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.MemberDao;
import dto.Member;
import dto.Payment;

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


	@Override
	public void insertPayment(Connection conn, Payment payment) {
		System.out.println(payment.toString());
		String sql = "";
		sql += "INSERT INTO payment";
		sql += " VALUES (?, ?, ?, ?)";
		
		int res = 0;
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
//			ps.setString(1, board.getTitle());
//			ps.setString(2, board.getUserid());
//			ps.setString(3, board.getContent());
			ps.setString(1, payment.getPaymentUid());
			ps.setString(2, payment.getAmt());
			ps.setString(3, payment.getMerchant_uid());
			ps.setString(4, payment.getUserid());

			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			JDBCTemplate.commit(conn);
		}
		
	}


	@Override
	public void updateMember(Connection conn, Payment payment) {
		System.out.println(payment.toString());
		String sql = "";
		sql +="UPDATE user_table SET"; 
		sql +=" grade = 1 WHERE USERID = ?";
		
		int res = 0;
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			//ps.setString(1, "1");
			ps.setString(1, payment.getUserid());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			JDBCTemplate.commit(conn);
		}
		
	}

}
