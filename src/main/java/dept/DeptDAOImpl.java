package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.DBUtil;
import member.MemberDTO;

public class DeptDAOImpl implements DeptDAO {

	@Override
	public int insert(DeptDTO dept) {
		String sql="insert into mydept values(?,?,?,?)";
		Connection con = null;
		PreparedStatement ptmt =null;
		int result = 0;
		try {
			con = DBUtil.getConnect();
			ptmt =  con.prepareStatement(sql);
			ptmt.setString(1, dept.getDeptno());
			ptmt.setString(2, dept.getDeptname());
			ptmt.setString(3, dept.getTel());
			ptmt.setString(4, dept.getAddr());
			result = ptmt.executeUpdate();
			System.out.println(result+"개 행 삽입성공!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}

	@Override
	public int delete(String deptno) {
		System.out.println(deptno);
		Connection con = null;
		PreparedStatement ptmt =null;
		StringBuffer sql=new StringBuffer();
		sql.append("delete mydept ");
		sql.append("where deptcode=?");
		int result = 0;
		try {
			con = DBUtil.getConnect();
			ptmt =  con.prepareStatement(sql.toString());
			ptmt.setString(1,deptno);
			result = ptmt.executeUpdate();
			System.out.println(result+"개 행 삭제성공!!");
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}

	@Override
	public List<DeptDTO> select() {
		Connection con = null;
		PreparedStatement ptmt =null;
		ResultSet rs = null;
		String sql = "select * from mydept";
		List<DeptDTO> userlist = new ArrayList<>();//레코드를 담을 자료구조
		DeptDTO dept = null;//조회한 레코드를 담을 객체
		try {
			con = DBUtil.getConnect();
			ptmt =  con.prepareStatement(sql);
			rs =  ptmt.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				//레코드의 한 컬럼들을 이용해서 MemberDTO객체를 생성
				dept = new DeptDTO(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4));
				userlist.add(dept);
			}
//			System.out.println("ArrayList저장된 레코드 갯수:"+userlist.size());
//			System.out.println(userlist);
		}  catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return userlist;
	}

}
