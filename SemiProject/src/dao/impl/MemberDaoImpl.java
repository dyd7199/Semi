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
	

	@Override
	public int insertByMemberInfo(Connection conn, Member member) {
		
		String sql ="INSERT INTO user_table( userno,userid,username,userpw,userbirth,phoneno,nick,email,gender,grade)";
		sql += " VALUES(seq_user.nextval,?,?,?,?,?,?,?,?,?)";
		
		
		int res = 0;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, member.getUserid());
			ps.setString(2, member.getUsername());
			ps.setString(3, member.getUserpw());
			ps.setString(4, member.getUserbirth());
			ps.setString(5, member.getPhoneno());
			ps.setString(6, member.getNick());
			ps.setString(7, member.getEmail());
			ps.setString(8, member.getGender());
			ps.setString(9, member.getGrade());
			
			res = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}


	@Override
	public int selectById(Connection conn, String userid) {
		String sql ="";
		sql +=" SELECT COUNT(*) CNT FROM user_table";
		sql +="	WHERE userid = ?";
		int res = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			
			rs = ps.executeQuery();
			
			
			while (rs.next()) {
				res = rs.getInt("cnt");
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return res;
	}


	@Override
	public int selectByNick(Connection conn, String nick) {
		String sql ="";
		sql +=" SELECT COUNT(*) CNT FROM user_table";
		sql +="	WHERE nick = ?";
		int res = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, nick);
			
			rs = ps.executeQuery();
			
			
			while (rs.next()) {
				res = rs.getInt("cnt");
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

}
