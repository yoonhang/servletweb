package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//insert,delete,update,select,login,search
//insert,delete,update의 실행 결과 - 실행이 완료된 레코드수가 반환이되고 0
public class MemberDAOImpl implements MemberDAO{
	@Override
	public int insert(MemberDTO user) {
		System.out.println("============================");
		System.out.println(user);//user.toString()가 생략
		String sql="insert into member values(?,?,?,?,sysdate,20000,?)";
		Connection con = null;
		PreparedStatement ptmt =null;
		int result = 0;
		try {
			con = DBUtil.getConnect();
			ptmt =  con.prepareStatement(sql);
			ptmt.setString(1, user.getId());
			ptmt.setString(2, user.getPass());
			ptmt.setString(3, user.getName());
			ptmt.setString(4, user.getAddr());
			ptmt.setString(5, user.getInfo());
			result = ptmt.executeUpdate();
			System.out.println(result+"개 행 삽입성공!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	
	
	
	
	public void insert(String id,String pass,String name,String addr,String info) {
		System.out.println(id+","+pass+","+name+","+addr+","+info);
		Connection con = null;
		String sql="insert into member values(?,?,?,?,sysdate,20000,?)";
		PreparedStatement ptmt =null;
		try {
			con = DBUtil.getConnect();
			ptmt =  con.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setString(2, pass);
			ptmt.setString(3, name);
			ptmt.setString(4, addr);
			ptmt.setString(5, info);
			int result = ptmt.executeUpdate();
			System.out.println(result+"개 행 삽입성공!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
	}
	public void update(String info,String addr,String id) {
		String sql = "update member ";
		sql = sql + "set addr = ?,info=? ";
		sql = sql + "where id = ?";
		Connection con = null;
		PreparedStatement ptmt =null;
		try {
			con = DBUtil.getConnect();
			ptmt =  con.prepareStatement(sql);
			ptmt.setString(1, addr);
			ptmt.setString(2, info);
			ptmt.setString(3, id);
			int result = ptmt.executeUpdate();
			System.out.println(result+"개 행 수정성공!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
	}

	@Override
	public void update(MemberDTO updateUser) {
		System.out.println("*************************");
		String sql = "update member ";
		sql = sql + "set addr = ?,info=? ";
		sql = sql + "where id = ?";
		Connection con = null;
		PreparedStatement ptmt =null;
		try {
			con = DBUtil.getConnect();
			ptmt =  con.prepareStatement(sql);
			ptmt.setString(1, updateUser.getAddr());
			ptmt.setString(2, updateUser.getInfo());
			ptmt.setString(3, updateUser.getId());
			int result = ptmt.executeUpdate();
			System.out.println(result+"개 행 수정성공!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		
	}
	public int delete(String id) {
		Connection con = null;
		PreparedStatement ptmt =null;
		StringBuffer sql=new StringBuffer();
		sql.append("delete member ");
		sql.append("where id=?");
		int result = 0;
		try {
			con = DBUtil.getConnect();
			ptmt =  con.prepareStatement(sql.toString());
			ptmt.setString(1,id);
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
	//조회한 테이블을 변환해서 호출한 곳으로 넘겨줄 수 있도록 작업
	//테이블에 레코드가 여러 개 있으므로 각 레코드를 DTO로 변환하고 이 DTO들을 ArrayList와 같은 자료구조에 담아서 넘겨줄 수 있도록 처리
	//                                                                               --------------
	//                                                                                 리턴
	//웹에서는 List로 변환해서 넘기는 것이 일반적
	public List<MemberDTO> select() {
		Connection con = null;
		PreparedStatement ptmt =null;
		ResultSet rs = null;
		String sql = "select * from member";
		List<MemberDTO> userlist = new ArrayList<>();//레코드를 담을 자료구조
		MemberDTO user = null;//조회한 레코드를 담을 객체
		try {
			con = DBUtil.getConnect();
			ptmt =  con.prepareStatement(sql);
			rs =  ptmt.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				//레코드의 한 컬럼들을 이용해서 MemberDTO객체를 생성
				user = new MemberDTO(rs.getString("id"), rs.getString("pass"),
						rs.getString("name"), rs.getString(4), rs.getDate(5),
						rs.getInt("point"),	rs.getString(7));
				userlist.add(user);
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
	//프라이머리키로 where에서 조건을 and로  적용하고 있으므로 결과는 무조건 1개
	//결과가 1개면 XXXDTO로 변환한다.
	public MemberDTO login(String id,String pass) {
		Connection con = null;
		PreparedStatement ptmt =null;
		ResultSet rs = null;
		MemberDTO loginUser = null;
		String sql = "select * from member where id=? and pass=?";
		try {
			con = DBUtil.getConnect();
			ptmt =  con.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setString(2, pass);
			rs =  ptmt.executeQuery();
			System.out.println(rs);
			if(rs.next()) {
				loginUser = new MemberDTO(rs.getString("id"), rs.getString("pass"),
						rs.getString("name"), rs.getString(4), rs.getDate(5),
						rs.getInt("point"),	rs.getString(7));
				System.out.print(rs.getString("name")+"님 로그인 성공");
			}
		}  catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return loginUser;
	}
	
	
	
	//검색결과가 0, 1 또는 많이
	//위와 같은 결과가 리턴되는 경우 ArrayList<XXXDTO>의 형태로 조회된 결과를 변환한다.
	public List<MemberDTO> search(String column,String value) {
		String sql = "";
		Connection con = null;
		PreparedStatement ptmt =null;
		ResultSet rs = null;
		List<MemberDTO> searchlist = new ArrayList<>();
		MemberDTO user = null;
		if(column.equals("addr")) { 
			sql = "select * from member where addr like ?";
		}else if(column.equals("name")) {
			sql = "select * from member where name like ?";
		}
		try {
			con = DBUtil.getConnect();
			ptmt =  con.prepareStatement(sql);
			ptmt.setString(1, "%"+value+"%");
			rs = ptmt.executeQuery();
			while(rs.next()) {
				user = new MemberDTO(rs.getString("id"), rs.getString("pass"),
						rs.getString("name"), rs.getString(4), rs.getDate(5),
						rs.getInt("point"),	rs.getString(7));
				searchlist.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return searchlist;
	}




	@Override
	public MemberDTO findById(String id) {
		Connection con = null;
		PreparedStatement ptmt =null;
		ResultSet rs = null;
		MemberDTO loginUser = null;
		String sql = "select * from member where id=?";
		try {
			con = DBUtil.getConnect();
			ptmt =  con.prepareStatement(sql);
			ptmt.setString(1, id);
	
			rs =  ptmt.executeQuery();
			System.out.println(rs);
			if(rs.next()) {
				loginUser = new MemberDTO(rs.getString("id"), rs.getString("pass"),
						rs.getString("name"), rs.getString(4), rs.getDate(5),
						rs.getInt("point"),	rs.getString(7));
			
			}
		}  catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return loginUser;
	}




	
}
